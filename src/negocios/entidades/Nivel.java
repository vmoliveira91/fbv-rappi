package negocios.entidades;

public class Nivel {
    private int idNivel;
    private String nome;
    private Beneficio[] beneficios;

    public Nivel(int idNivel, String nome) {
        this.idNivel = idNivel;
        this.nome = nome;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Beneficio[] getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(Beneficio[] beneficios) {
        this.beneficios = beneficios;
    }
}
