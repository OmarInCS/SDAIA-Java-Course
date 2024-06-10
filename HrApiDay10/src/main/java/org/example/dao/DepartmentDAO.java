package org.example.dao;


import org.example.dto.DepartmentFilterDto;
import org.example.models.Department;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class DepartmentDAO implements Serializable {

    private static final String URL = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_DEPTS = "select * from departments";
    private static final String SELECT_ONE_DEPT = "select * from departments where department_id = ?";
    private static final String SELECT_ONE_DEPT_JOIN_LOC = "select * from departments join locations on departments.location_id = locations.location_id where department_id = ?";
    private static final String SELECT_DEPT_WITH_LOC = "select * from departments where location_id = ?";
    private static final String SELECT_DEPT_WITH_LOC_PAGINATION = "select * from departments where location_id = ? order by department_id limit ? offset ?";
    private static final String SELECT_DEPT_WITH_PAGINATION = "select * from departments order by department_id limit ? offset ?";
    private static final String INSERT_DEPT = "insert into departments values (?, ?, ?)";
    private static final String UPDATE_DEPT = "update departments set department_name = ?, location_id = ? where department_id = ?";
    private static final String DELETE_DEPT = "delete from departments where department_id = ?";

    public void insertDept(Department d) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_DEPT);
        st.setInt(1, d.getDepartmentId());
        st.setString(2, d.getDepartmentName());
        st.setInt(3, d.getLocationId());
        st.executeUpdate();
    }

    public void updateDept(Department d) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_DEPT);
        st.setInt(3, d.getDepartmentId());
        st.setString(1, d.getDepartmentName());
        st.setInt(2, d.getLocationId());
        st.executeUpdate();
    }

    public void deleteDept(int deptId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_DEPT);
        st.setInt(1, deptId);
        st.executeUpdate();
    }

    public Department selectDept(int deptId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(SELECT_ONE_DEPT);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_DEPT_JOIN_LOC);
        st.setInt(1, deptId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Department(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Department> selectAllDepts(Integer locId, Integer limit, int offset) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(locId != null && limit != null) {
            st = conn.prepareStatement(SELECT_DEPT_WITH_LOC_PAGINATION);
            st.setInt(1, locId);
            st.setInt(2, limit);
            st.setInt(3, offset);
        }
        else if(locId != null) {
            st = conn.prepareStatement(SELECT_DEPT_WITH_LOC);
            st.setInt(1, locId);
        }
        else if(limit != null) {
            st = conn.prepareStatement(SELECT_DEPT_WITH_PAGINATION);
            st.setInt(1, limit);
            st.setInt(2, offset);
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_DEPTS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Department> depts = new ArrayList<>();
        while (rs.next()) {
            depts.add(new Department(rs));
        }

        return depts;
    }

    public ArrayList<Department> selectAllDepts(DepartmentFilterDto filter) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(filter.getLocId() != null && filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_DEPT_WITH_LOC_PAGINATION);
            st.setInt(1, filter.getLocId());
            st.setInt(2, filter.getLimit());
            st.setInt(3, filter.getOffset());
        }
        else if(filter.getLocId() != null) {
            st = conn.prepareStatement(SELECT_DEPT_WITH_LOC);
            st.setInt(1, filter.getLocId());
        }
        else if(filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_DEPT_WITH_PAGINATION);
            st.setInt(1, filter.getLimit());
            st.setInt(2, filter.getOffset());
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_DEPTS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Department> depts = new ArrayList<>();
        while (rs.next()) {
            depts.add(new Department(rs));
        }

        return depts;
    }
}
