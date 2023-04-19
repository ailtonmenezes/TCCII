import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class configMySQL {
    private static configMySQL instance = null;
    private Connection connection = null;

    private configMySQL() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/unicesumartcc",
                    "root",
                    "Senha do banco de dados!");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static configMySQL getInstance() throws SQLException {
        if (instance == null) {
            instance = new configMySQL();
        } else if (instance.getConnection().isClosed()) {
            instance = new configMySQL();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
