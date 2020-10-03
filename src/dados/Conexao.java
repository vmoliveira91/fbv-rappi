package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private Connection conexao;
    
    public boolean conectar() {
        try {
            // Cada um adiciona seu path
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:banco/rappi-db.sqlite";
            
            this.conexao = DriverManager.getConnection(url);
            this.conexao.setAutoCommit(false);
            
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return true;
    }

    public boolean desconectar() {

        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        }

        return true;
    }

    public Statement criarStatement() {
        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public void commit() {
        try {
            this.conexao.commit();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
