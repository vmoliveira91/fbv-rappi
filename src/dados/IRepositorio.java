package dados;

import java.util.ArrayList;
import negocios.entidades.Usuario;

public interface IRepositorio {
    public boolean inserirTransacao(int usuarioId, double valor, String tipo, String formaPagamento);
    
    public ArrayList<Object> informarTransacoes();
    
    public int informarPontuacao(int usuarioId);
    
    public Object[] informarDadosUsuario(int usuarioId);
            
    public ArrayList<Usuario> listarUsuarios();
}
