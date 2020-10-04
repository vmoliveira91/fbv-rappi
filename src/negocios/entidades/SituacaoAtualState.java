package negocios.entidades;

public class SituacaoAtualState extends SituacaoState {
    public SituacaoAtualState(Periodo periodo) {
        super(periodo);
        periodo.mudarSituacao(new Situacao(1, "Atual"));
    }
}
