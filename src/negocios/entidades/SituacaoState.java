package negocios.entidades;

public abstract class SituacaoState {
    Periodo periodo;
    
    public SituacaoState(Periodo periodo) {
        this.periodo = periodo;
    }
}
