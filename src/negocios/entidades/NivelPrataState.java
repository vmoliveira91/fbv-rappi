package negocios.entidades;

public class NivelPrataState extends NivelState {
    public NivelPrataState(Usuario usuario) {
        super(usuario);
        usuario.mudarNivel(new Nivel(2, "Prata"));
    }
}
