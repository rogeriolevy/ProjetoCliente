package sistema.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection manager class.
 * Handles MySQL database connections.
 */
public class Conexao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/banco";
    private static final String DB_USER = "rogerio";
    private static final String DB_PASSWORD = "1234";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private Connection connection;

    /**
     * Opens a database connection.
     * @return Connection object if successful, null otherwise
     */
    public Connection abrirBDConn() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Conexao efetuada com sucesso");
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao abrir conexao com banco: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Closes the database connection.
     */
    public void fecharBDConn() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexao finalizada com sucesso");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexao com banco: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}