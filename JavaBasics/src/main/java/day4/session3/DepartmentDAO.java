package day4.session3;

import day4.session1.Department;

import java.sql.*;
import java.util.ArrayList;

public class DepartmentDAO {

    private static final String URL = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_DEPTS = "select * from departments";
    private static final String SELECT_ONE_DEPT = "select * from departments where department_id = ?";
    private static final String INSERT_DEPT = "insert into departments values (?, ?, ?)";
    private static final String UPDATE_DEPT = "update departments set department_name = ?, location_id = ? where department_id = ?";
    private static final String DELETE_DEPT = "delete from departments where department_id = ?";

    public void insertDept(Department d) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_DEPT);
        st.setInt(1, d.getDepartmentId());
        st.setString(2, d.getDepartmentName());
        st.setInt(3, d.getLocationId());
        st.executeUpdate();
    }

    public void updateDept(Department d) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_DEPT);
        st.setInt(3, d.getDepartmentId());
        st.setString(1, d.getDepartmentName());
        st.setInt(2, d.getLocationId());
        st.executeUpdate();
    }

    public void deleteDept(int deptId) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_DEPT);
        st.setInt(1, deptId);
        st.executeUpdate();
    }

    public Department selectDept(int deptId) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_DEPT);
        st.setInt(1, deptId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Department(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Department> selectAllDepts() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_DEPTS);
        ResultSet rs = st.executeQuery();
        ArrayList<Department> depts = new ArrayList<>();
        while (rs.next()) {
            depts.add(new Department(rs));
        }

        return depts;
    }

}
