package negocios.entidades;

public class Profile {
    private int idProfile;
    private Usuario usuario;
    private Periodo[] periodos;
    private Transacao[] transacoes;
    private int pontos;

    public Profile() {
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Periodo[] getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Periodo[] periodos) {
        this.periodos = periodos;
    }

    public Transacao[] getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Transacao[] transacoes) {
        this.transacoes = transacoes;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
