package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;

public class Repositorio implements IRepositorio {
    private Conexao conexao;

    public Repositorio() {
        this.conexao = new Conexao();
    }
    
    @Override
    public boolean inserirTransacao(int usuarioId, double valor, String tipo, String formaPagamento, Date data) {
        // Implementar a lógica aqui
        return true;
    }

    @Override
    public ArrayList<Object> informarTransacoes() {
        // Implementar a lógica aqui
        this.conexao.conectar();
        System.out.println("Conectou!");
        this.conexao.desconectar();
        return null;//new ArrayList<Object>();
    }

    @Override
    public int informarPontuacao(int usuarioId) {
        // Implementar a lógica aqui
        return 0;
    }

    @Override
    public String informarDadosUsuario(int usuarioId) {
        // Implementar a lógica aqui
        return "Santhi lindo!";
    }
}
