package day4.session3;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnPoolConfig {

    private static String url = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(url);
        ds = new HikariDataSource(config);
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
