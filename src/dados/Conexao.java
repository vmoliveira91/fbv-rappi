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
            String url = "C:\\Users\\VITOR.OLIVEIRA\\Documents\\NetBeansProjects\\fbv-rappi\\rappi-db.db";

            this.conexao = DriverManager.getConnection(url);
        } catch(SQLException e) {
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
}
