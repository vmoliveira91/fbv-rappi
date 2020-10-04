package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import negocios.entidades.Beneficio;
import negocios.entidades.NivelDiamanteState;
import negocios.entidades.NivelOuroState;
import negocios.entidades.NivelPrataState;
import negocios.entidades.NivelState;
import negocios.entidades.Periodo;
import negocios.entidades.SituacaoFinalizadoState;
import negocios.entidades.Transacao;
import negocios.entidades.TransacaoB;
import negocios.entidades.TransacaoPOD;
import negocios.entidades.Usuario;

public class Repositorio implements IRepositorio {
    private Conexao conexao;

    public Repositorio() {
        this.conexao = new Conexao();
    }    
    
    @Override
    public boolean inserirTransacao(int usuarioId, double valor, String tipo, String formaPagamento) {
        this.conexao.conectar();
        
        Transacao t = null;
        ArrayList<Beneficio> beneficios = new ArrayList<Beneficio>();
        
        ResultSet rs = null;
        Statement st = null;
        
        try {
            // Busca nível do usuário
            String nivelUsuarioSelect = "SELECT nivelId FROM usuario WHERE id = " + usuarioId + ";";
            
            st = this.conexao.criarStatement();
            rs = st.executeQuery(nivelUsuarioSelect);
            
            int nivelUsuario = rs.getInt("nivelId");
            
            // Busca benefícios do nível
            String beneficiosSelect = 
                    "SELECT B.nome nome, B.tipo tipo, NB.valor valor " +
                    "FROM nivelBeneficio NB " +
                    "JOIN beneficio B ON NB.beneficioId = B.id " +
                    "WHERE NB.nivelId = " + nivelUsuario + ";";     
            
            st = this.conexao.criarStatement();                   
            rs = st.executeQuery(beneficiosSelect);
            
            while(rs.next()) {
                Beneficio ben = new Beneficio(rs.getString("nome"), rs.getString("tipo"), rs.getDouble("valor"));
                beneficios.add(ben);
            }           
            
            // De acordo o nível do usuário efetua a transação que gera o valor final e a quantidade de pontos
            switch(nivelUsuario) {
                case 1:
                    t = new TransacaoB(usuarioId, valor, tipo, formaPagamento, null);
                    t.efetuarTransacao();
                    break;
                case 2:
                case 3:
                case 4:
                    t = new TransacaoPOD(usuarioId, valor, tipo, formaPagamento, null, beneficios);
                    t.efetuarTransacao();
                    break;
                default:
                    break;
            }
            
            String getDate = "SELECT datetime('now') data;";
                    
            rs = st.executeQuery(getDate);
            
            String data = rs.getString("data");
            
            // Cria a transação no banco e pega seu id
            String insertTransacao =
                    "INSERT INTO transacao (valor, tipo, formaPagamento, data) " +
                    "VALUES(" + t.getValor() + ", '" + t.getTipo() + "', '" + t.getFormaPagamento() + "', '" + data + "');";
            
            st.executeUpdate(insertTransacao);
            int transacaoId = st.getGeneratedKeys().getInt(1);
                        
            // Busca a quantidade de pontos necessários e quantos pontos já possui o período atual do usuário            
            String periodoPontosSelect =
                    "SELECT P.id id, P.pontosNecessarios pontosNecessarios, SUM(UPT.pontos) pontos " +
                    "FROM periodo P " +
                    "JOIN situacao S ON P.situacaoId = S.id " +
                    "JOIN usuarioPeriodoTransacao UPT " +
                    "WHERE UPT.usuarioId = " + usuarioId + " AND S.id = 1 " +
                    "GROUP BY P.id";
            
            rs = st.executeQuery(periodoPontosSelect);
            
            int periodoId = rs.getInt("id");
            int pontosNecessarios = rs.getInt("pontosNecessarios");
            int pontosAtuais = rs.getInt("pontos");
            
            // Verifica se com a adição dos pontos a pontuação do período vai estar completa
            // Para atualizar o status do período e o nível do usuário
            if(pontosAtuais + t.getPontos() >= pontosNecessarios) {
                Periodo p = new Periodo();
                p.setIdPeriodo(periodoId);
                SituacaoFinalizadoState sfs = new SituacaoFinalizadoState(p);
                                
                Usuario u = new Usuario();
                u.setIdUsuario(usuarioId);
                
                switch(nivelUsuario) {
                    case 1:
                        NivelPrataState nps = new NivelPrataState(u);
                        break;
                    case 2:
                        NivelOuroState nos = new NivelOuroState(u);
                        break;
                    case 3:
                        NivelDiamanteState nds = new NivelDiamanteState(u);
                        break;                   
                }
                
                String updatePeriodo = 
                        "UPDATE periodo " +
                        "SET situacaoId = " + p.getSituacao().getIdSituacao() + ", dataConclusao = datetime('now') " +
                        "WHERE id = " + p.getIdPeriodo() + ";";
                
                st.executeUpdate(updatePeriodo);
                
                String updateUsuario =
                        "UPDATE usuario " +
                        "SET nivelId = " + u.getNivel().getIdNivel() + " " +
                        "WHERE id = " + u.getIdUsuario();
                
                st.executeUpdate(updateUsuario);
            }
            
            // Cria um registro na usuarioPeriodoTransacao
            int pontos = (pontosNecessarios - pontosAtuais < t.getPontos()) ?  pontosNecessarios - pontosAtuais : t.getPontos();
            
            String insertUsuarioPeriodoTransacao =
                    "INSERT INTO usuarioPeriodoTransacao(usuarioId, periodoId, transacaoId, pontos) " +
                    "VALUES(" + usuarioId + ", " + periodoId + ", " + transacaoId + ", " + pontos + ");";
            
            st.executeUpdate(insertUsuarioPeriodoTransacao);
            
            //this.conexao.commit();
            st.close();
            rs.close();
            this.conexao.desconectar();            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }        
        return true;
    }

    @Override
    public ArrayList<Object> informarTransacoes() {
        // Implementar a lógica aqui
        return null;//new ArrayList<Object>();
    }

    @Override
    public int informarPontuacao(int usuarioId) {
        this.conexao.conectar();
       
        ResultSet rs = null;
        Statement st = null;
        
        int pontos = 0;
        
       try {
           
        st = this.conexao.criarStatement();
           
        String selectPontuacao = 
                "SELECT SUM(UPT.pontos) pontos\n" +
                "FROM usuarioPeriodoTransacao UPT \n" +
                "JOIN periodo P ON UPT.periodoId = P.Id\n" +
                "JOIN situacao S ON P.situacaoId = S.id AND S.nome = (SELECT nome FROM situacao WHERE nome = 'Atual')\n" +
                "WHERE UPT.usuarioId = " + usuarioId + "\n" +
                "GROUP BY P.id" ;
        rs = st.executeQuery(selectPontuacao);
        
        pontos = rs.getInt("pontos");
       } catch(SQLException e) {
           System.out.println(e.getMessage());
       }       
        return pontos;
    }

    @Override
    public String informarDadosUsuario(int usuarioId) {
        // Implementar a lógica aqui
        return "Santhi lindo!";
    }
    
    @Override
    public ArrayList<Usuario> listarUsuarios(){
        this.conexao.conectar();
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        ResultSet rs = null;
        Statement st = null;
        
        try {
            st = this.conexao.criarStatement();
            String listUsuarios = "SELECT Id, nome FROM usuario";
            
            rs = st.executeQuery(listUsuarios);
            while(rs.next()){
                Usuario usuario = new Usuario(rs.getInt("Id"),rs.getString("nome"));
                usuarios.add(usuario);
            }
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }     
        return usuarios;
    }
}
