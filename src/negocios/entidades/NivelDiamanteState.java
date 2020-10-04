package negocios.entidades;

public class NivelDiamanteState extends NivelState {
    public NivelDiamanteState(Usuario usuario) {
        super(usuario);
        usuario.mudarNivel(new Nivel(4, "Diamante"));
    }
}
