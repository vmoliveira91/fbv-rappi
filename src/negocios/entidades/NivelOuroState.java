package negocios.entidades;

public class NivelOuroState extends NivelState {
    public NivelOuroState(Usuario usuario) {
        super(usuario);
        usuario.mudarNivel(new Nivel(3, "Ouro"));
    }
}
