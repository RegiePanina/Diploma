package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();
    private static String url = System.getProperty("db.url");
    public SQLHelper() {
    }
    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection(url, "app", "pass");
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConn();
        runner.execute(connection, "DElETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var status = "SELECT status FROM payment_entity";
        try (var conn = getConn()) {
            return runner.query(conn, status, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var status = "SELECT status FROM credit_request_entity";
        try (var conn = getConn()) {
            return runner.query(conn, status, new ScalarHandler<>());
        }
    }
}
