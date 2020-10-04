import java.util.Scanner;
import negocios.Fachada;
import negocios.entidades.Usuario;

public class Main {
    public static void main(String[] args) {
        Fachada f = Fachada.getInstancia();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione o ID do usuário:");
       
        for(Usuario u : f.listarUsuario()) {
            System.out.println("Id: " + u.getIdUsuario() + " Nome: " + u.getNome());
        }       
        int usuarioId = sc.nextInt();
       
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Informar dados do usuário");
        System.out.println("2 - Inserir uma transação");
        System.out.println("3 - Informar transações");
        System.out.println("4 - Informar pontos");
        System.out.println("5 - Finalizar consulta");
        int opcao = sc.nextInt();

        while(opcao != 5){
            if(opcao == 1){
                f.informarDadosUsuario(usuarioId);
            } else if (opcao ==2){
                System.out.println("Informe o valor da transação:");
                double valor = sc.nextDouble();
                System.out.println("Informe o tipo de transação:");
                String tipo = sc.nextLine();
                System.out.println("Informe a forma de pagamento:");
                String pagamento = sc.nextLine();
                f.inserirTransacao(usuarioId, valor, tipo, pagamento);
                System.out.println("Transacão inserida com sucesso!");
                break;
            } else if (opcao == 3) {
                f.informarTransacoes();
            } else if (opcao ==4){
                System.out.println(f.informarPontuacao(usuarioId));                
                break;
            } else {
                System.out.println("Consulta finalizada!");
                break;
            }
       }        
    }
}
