package negocios.entidades;

public class SituacaoFinalizadoState extends SituacaoState {
    public SituacaoFinalizadoState(Periodo periodo) {
        super(periodo);
        periodo.mudarSituacao(new Situacao(2, "Finalizado"));
    }
}
