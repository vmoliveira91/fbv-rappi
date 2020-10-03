package negocios.entidades;

import java.util.ArrayList;
import java.util.Date;

public class TransacaoPOD extends Transacao {
    private ArrayList<Beneficio> beneficios;
    
    public TransacaoPOD(int usuarioId, double valor, String tipo, String formaPagamento, Date data, ArrayList<Beneficio> beneficios) {
        super(usuarioId, valor, tipo, formaPagamento, data);
        this.beneficios = beneficios;
    }
    
    public void aplicarBeneficios() {
        for(Beneficio b : this.beneficios) {
            if(b.getTipo().equals(this.getTipo())) {
                this.setValor(this.getValor() - b.getValor());
            }
        }
    }    
}
