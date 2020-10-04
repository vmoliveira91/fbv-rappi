
package negocios.entidades;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String cpf;
    private int telefone;
    private NivelState state;
    private Nivel nivel;

    public Usuario() {}
    
    public Usuario(int idUsuario, String nome) {
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    public NivelState getNivelState() {
        return this.state;
    }
    
    public Nivel getNivel() {
        return this.nivel;
    }
    
    public void mudarNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
