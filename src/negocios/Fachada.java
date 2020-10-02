package negocios;

import negocios.controladores.Controlador;

import java.util.ArrayList;
import java.util.Date;

public class Fachada implements IFachada {
    private Controlador cont;
    private static Fachada instancia;

    private Fachada() {
        this.cont = new Controlador();
    }

    // Singleton
    public static Fachada getInstancia() {
        if(instancia == null)
            instancia = new Fachada();
        
        return instancia;
    }

    @Override
    public boolean inserirTransacao(int usuarioId, double valor, String tipo, String formaPagamento, Date data) {
        return this.cont.inserirTransacao(usuarioId, valor, tipo, formaPagamento, data);
    }

    @Override
    public ArrayList<Object> informarTransacoes() {
        return this.cont.informarTransacoes();
    };

    @Override
    public int informarPontuacao(int usuarioId) {
        return this.cont.informarPontuacao(usuarioId);
    };

    @Override
    public String informarDadosUsuario(int usuarioId) {
        return this.cont.informarDadosUsuario(usuarioId);
    } 
}