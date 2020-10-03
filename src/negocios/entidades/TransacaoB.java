package negocios.entidades;

import java.util.Date;

public class TransacaoB extends Transacao {
    public TransacaoB(int usuarioId, double valor, String tipo, String formaPagamento, Date data) {
        super(usuarioId, valor, tipo, formaPagamento, data);
    }
    
    @Override
    public void aplicarBeneficios() {}
}
