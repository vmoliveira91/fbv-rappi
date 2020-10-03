package negocios.entidades;

public class SituacaoFinalizadoState extends SituacaoState {
    public SituacaoFinalizadoState() {
        super();
        this.situacao.setIdSituacao(2);
        this.situacao.setNome("Finalizado");
    }
}
