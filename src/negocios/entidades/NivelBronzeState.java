package negocios.entidades;

public class NivelBronzeState extends NivelState{
    public NivelBronzeState(Usuario usuario) {
        super(usuario);
        usuario.mudarNivel(new Nivel(1, "Bronze"));
    }
    
}
