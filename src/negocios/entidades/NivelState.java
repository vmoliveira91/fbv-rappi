package negocios.entidades;

public abstract class NivelState {
    Usuario usuario;
    
    public NivelState(Usuario usuario) {
        this.usuario = usuario;
    }
}
