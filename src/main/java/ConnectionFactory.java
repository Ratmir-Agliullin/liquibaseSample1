import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/brontozavr",
                    "postgres", "123456");
        } catch (SQLException e) {
            System.out.println("Подключение не установлено");
        }
        return connection;
    }
}
