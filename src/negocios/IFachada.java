package negocios;

import java.util.ArrayList;

import negocios.entidades.Usuario;

public interface IFachada {
    public boolean inserirTransacao(int usuarioId, double valor, String tipo, String formaPagamento);

    public ArrayList<Object> informarTransacoes();

    public int informarPontuacao(int usuarioId);

    public String informarDadosUsuario(int usuarioId);
    
    public ArrayList<Usuario> listarUsuario();
}