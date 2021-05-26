package CONEXAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
     public Connection conect() {
        try {
            String url = "jdbc:postgresql://localhost:5432/locadora";
            String user = "postgres";
            String senha = "SENHA";
            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
} 
