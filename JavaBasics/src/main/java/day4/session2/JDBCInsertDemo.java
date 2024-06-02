package day4.session2;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsertDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
        String query = "insert into departments values (?, ?, ?)";


        try (Connection conn = DriverManager.getConnection(url);) {

            PreparedStatement st = conn.prepareStatement(query);
            System.out.println("Enter department ID: ");
            int deptId = sc.nextInt();
            st.setInt(1, deptId);
            sc.nextLine();

            System.out.println("Enter department Name: ");
            String deptName = sc.nextLine();
            st.setString(2, deptName);

            System.out.println("Enter location ID: ");
            int locId = sc.nextInt();
            st.setInt(3, locId);

            int rows = st.executeUpdate();

            System.out.println(rows + " inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
