package negocios.entidades;

public class Situacao {
    private int idSituacao;
    private String nome;

    public Situacao(int idSituacao, String nome) {
        this.idSituacao = idSituacao;
        this.nome = nome;
    }

    public int getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(int idSituacao) {
        this.idSituacao = idSituacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
