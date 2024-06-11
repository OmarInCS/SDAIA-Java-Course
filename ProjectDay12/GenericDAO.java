package com.example.DemoGroup.day4.session3;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T> {

    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public void insert(T obj) throws SQLException, IllegalAccessException {
        String sql = generateInsertSQL(obj);
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setPreparedStatementParameters(preparedStatement, obj);
            preparedStatement.executeUpdate();
        }
    }

    public T selectById(int id) throws SQLException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        T obj = null;
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                obj = type.newInstance();
                mapResultSetToObject(rs, obj);
            }
        }
        return obj;
    }

    public List<T> selectAll() throws SQLException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM " + getTableName();
        List<T> list = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                T obj = type.newInstance();
                mapResultSetToObject(rs, obj);
                list.add(obj);
            }
        }
        return list;
    }

    public boolean update(T obj, int id) throws SQLException, IllegalAccessException {
        String sql = generateUpdateSQL(obj);
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setPreparedStatementParameters(preparedStatement, obj);
            preparedStatement.setInt(getFieldCount(obj) + 1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    protected abstract String getTableName();
    protected abstract String getIdColumnName();

    private String generateInsertSQL(T obj) {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(getTableName()).append(" (");
        StringBuilder values = new StringBuilder("VALUES (");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            sql.append(field.getName().replaceAll("([a-z])([A-Z]+)", "$1_$2")).append(",");
            values.append("?,");
        }
        sql.deleteCharAt(sql.length() - 1).append(") ");
        values.deleteCharAt(values.length() - 1).append(")");
        sql.append(values);
        return sql.toString();
    }

    private String generateUpdateSQL(T obj) {
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(getTableName()).append(" SET ");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            sql.append(field.getName().replaceAll("([a-z])([A-Z]+)", "$1_$2")).append(" = ?,");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" WHERE ").append(getIdColumnName()).append(" = ?");
        return sql.toString();
    }

    private void setPreparedStatementParameters(PreparedStatement preparedStatement, T obj) throws SQLException, IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        int index = 1;
        for (Field field : fields) {
            field.setAccessible(true);
            preparedStatement.setObject(index++, field.get(obj));
        }
    }

    private void mapResultSetToObject(ResultSet rs, T obj) throws SQLException, IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(obj, rs.getObject(field.getName().replaceAll("([a-z])([A-Z]+)", "$1_$2")));
        }
    }

    private int getFieldCount(T obj) {
        return obj.getClass().getDeclaredFields().length;
    }
}

