

package DAO_Classes;
import Classes.Passageiro;
import Database_Connection.ConectaBanco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class PassageiroDAO {
    
    // buscar por cpf retorna nome -- OK
    // inserir dados -- OK
    // alterar -- OK
    // deletar -- OK
    // select todos cadastrados -- OK
    
    private static final String PASSAGEIROS_CADASTRADOS = "select * from passageiro";
    private static final String NOVO_PASSAGEIRO = "insert into passageiro (cpf, nome, telefone, nascimento)  values (?,?, ?,?)";
    private static final String APAGAR_REGISTRO = "delete from passageiro where cpf = ?"; // ao deletar chamar primeiro o métodopara deletar o tiket associado a esse passageiro
    private static final String BUSCAR_NOME = "select nome from passageiro where cpf = ?";
    private static final String ATUALIZAR_CADASTRO = "update passageiro set nome = ?, telefone = ?, nascimento = ? where cpf = ?";
    
    
    public List<Passageiro> listarTodosPassageiros(){
        List<Passageiro> PassageirosCadastrados = new ArrayList<>();
        try{
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement comandoListar = conexao.prepareStatement(PASSAGEIROS_CADASTRADOS);
            ResultSet resultado = comandoListar.executeQuery();
            while(resultado.next()){
                Passageiro passageiro = new Passageiro();
                passageiro.setCpf(resultado.getLong("cpf"));
                passageiro.setNome(resultado.getString("nome"));
                passageiro.setTelefone(resultado.getString("telefone"));
                passageiro.setNascimento(resultado.getString("nascimento"));

                PassageirosCadastrados.add(passageiro);



            }
            conexao.close();
            
            
        }
        catch(SQLException exception){
               exception.getMessage();
        }
        return PassageirosCadastrados;
    }
    
    public boolean cadastrarPassageiro(Passageiro novoPassageiro) throws SQLException{
        
        // verifica se o passageiro já está cadastrado;
        for(Passageiro p: listarTodosPassageiros()){
            if(novoPassageiro.getCpf() == p.getCpf()){
                return false;
            }
        }
        
        try (Connection conexao = ConectaBanco.getConexao()) {
            PreparedStatement comandoCadastrar = conexao.prepareStatement(NOVO_PASSAGEIRO);
            comandoCadastrar.setLong(1, novoPassageiro.getCpf());
            comandoCadastrar.setString(2,novoPassageiro.getNome());
            comandoCadastrar.setString(3,novoPassageiro.getTelefone());
            comandoCadastrar.setString(4, novoPassageiro.getNascimento());
            
            comandoCadastrar.execute();
        }
        return true;
    }
    
    public boolean deletarCadastro(int cpf) throws SQLException{
        
        // apagar tiket ligados ao cpf
        
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoDeletar = conexao.prepareStatement(APAGAR_REGISTRO);
        comandoDeletar.setInt(1,cpf);
        
        return comandoDeletar.execute();
    }
    
    public String buscarNome(int cpf) throws SQLException{
        
        String nome = "";
        
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoBuscarNome = conexao.prepareStatement(BUSCAR_NOME);
        comandoBuscarNome.setInt(1, cpf);
        ResultSet resultado = comandoBuscarNome.executeQuery();
        if(resultado.next()){
           nome = resultado.getString("nome");
        }
        conexao.close();
        return nome;
    }
    
    public void atualizaCadastroDePassageiro(Passageiro novosDados) throws SQLException{
        
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoAtualizar = conexao.prepareStatement(ATUALIZAR_CADASTRO);
        comandoAtualizar.setString(1, novosDados.getNome());
        comandoAtualizar.setString(2, novosDados.getTelefone());
        comandoAtualizar.setString(3,novosDados.getNascimento());
        
        // cpf não muda, ele está sendo usado como campo de busca;
        comandoAtualizar.setLong(4, novosDados.getCpf());
        
        comandoAtualizar.execute();
        conexao.close();
        
    }
}
