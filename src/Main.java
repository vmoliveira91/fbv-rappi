import negocios.Fachada;

public class Main {
    public static void main(String[] args) {
        Fachada f = Fachada.getInstancia();
        
        f.informarTransacoes();
    }
}
