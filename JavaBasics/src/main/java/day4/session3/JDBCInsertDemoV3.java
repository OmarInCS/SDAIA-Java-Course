package day4.session3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertDemoV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
        String query = "insert into departments values (?, ?, ?)";


        try (Connection conn = DriverManager.getConnection(url);) {
            conn.setAutoCommit(false);
            PreparedStatement st = conn.prepareStatement(query);

            while (true) {


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

                st.addBatch();


                sc.nextLine();
                System.out.println("Do you want to save: ");
                String toSave = sc.nextLine();
                if(toSave.equals("yes")) {
                    int[] rows = st.executeBatch();
                    for (int r : rows) {
                        System.out.println(r + " inserted");
                    }
                    conn.commit();
                    System.out.println("Data saved");
                    break;
                } else if (toSave.equals("no")) {
                    conn.rollback();
                    System.out.println("Save cancelled");
                    break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
