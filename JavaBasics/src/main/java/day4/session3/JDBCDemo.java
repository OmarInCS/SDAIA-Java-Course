package day4.session3;

import day4.session1.Department;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        String query = "select * from departments where location_id = 1700";

        try (Connection conn = ConnPoolConfig.getConnection();) {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Department d = new Department(rs);
                System.out.println(d);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
