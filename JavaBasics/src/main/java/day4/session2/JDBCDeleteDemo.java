package day4.session2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDeleteDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
        String query = "delete from departments where department_id = ?";


        try (Connection conn = DriverManager.getConnection(url);) {

            PreparedStatement st = conn.prepareStatement(query);
            System.out.println("Enter department ID: ");
            int deptId = sc.nextInt();
            st.setInt(1, deptId);
            sc.nextLine();

            int rows = st.executeUpdate();

            System.out.println(rows + " deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
