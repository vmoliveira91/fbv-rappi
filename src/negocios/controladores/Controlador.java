package negocios.controladores;

import dados.*;
import negocios.entidades.Usuario;

import java.util.ArrayList;

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

    public boolean inserirTransacao(int usuarioId, double valor, String tipo, String formaPagamento) {
        return this.rep.inserirTransacao(usuarioId, valor, tipo, formaPagamento);
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
    
    public ArrayList<Usuario> listarUsuarios() {
        return this.rep.listarUsuarios();
    }
}
