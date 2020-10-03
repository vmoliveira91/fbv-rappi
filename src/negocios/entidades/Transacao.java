package negocios.entidades;

import java.util.Date;

public abstract class Transacao {
    private int idTransacao;
    private Usuario usuario;    
    private double valor;
    private String tipo;
    private String formaPagamento;
    private Date data;
    private int pontos;
    
    public Transacao(int usuarioId, double valor, String tipo, String formaPagamento, Date data) {
        this.usuario = new Usuario();
        this.usuario.setIdUsuario(usuarioId);
        this.valor = valor;
        this.tipo = tipo;
        this.formaPagamento = formaPagamento;
        this.data = data;
    }
    
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario ) {
        this.usuario = usuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    public void efetuarTransacao() {
        this.aplicarBeneficios();
        this.calcularPontos();
    }
    
    public void calcularPontos() {
        switch(this.formaPagamento) {
            case "cartão":
            case "rappipay":
                this.pontos = (int) (1.5 *  this.valor);
                break;
            case "prime":
            case "qrcode":
                this.pontos = (int) (2 * this.valor);
                break;
            default:
                this.pontos = 0;
                break;
        }
    }
    
    abstract void aplicarBeneficios();
}
