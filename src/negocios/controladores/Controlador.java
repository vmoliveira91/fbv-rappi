package negocios.controladores;

import dados.*;
import java.util.ArrayList;
import java.util.Date;

public class Controlador {
    private IRepositorio rep;

    public Controlador() {
        this.rep = new Repositorio();
    }

    public IRepositorio getRep() {
        return this.rep;
    }

    public void setRep(IRepositorio rep) {
        this.rep = rep;
    }

    public boolean inserirTransacao(int usuarioId, double valor, String tipo, String formaPagamento, Date data) {
        return this.rep.inserirTransacao(usuarioId, valor, tipo, formaPagamento, data);
    }

    public ArrayList<Object> informarTransacoes() {
        return this.rep.informarTransacoes();
    }

    public int informarPontuacao(int usuarioId) {
        return this.rep.informarPontuacao(usuarioId);
    }

    public String informarDadosUsuario(int usuarioId) {
        return this.rep.informarDadosUsuario(usuarioId);
    }
}
