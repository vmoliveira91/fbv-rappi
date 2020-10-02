package negocios;

import java.util.ArrayList;
import java.util.Date;

public interface IFachada {
    public boolean inserirTransacao(int usuarioId, double valor, String tipo, String formaPagamento, Date data);

    public ArrayList<Object> informarTransacoes();

    public int informarPontuacao(int usuarioId);

    public String informarDadosUsuario(int usuarioId);
}