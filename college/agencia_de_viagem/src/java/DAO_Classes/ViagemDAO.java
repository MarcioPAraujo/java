
package DAO_Classes;

import Classes.Viagem;
import Database_Connection.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ViagemDAO {
    
    private static final String VIAGEM_CADASTRADAS = "select * from viagem";
    private static final String NOVA_VIAGEM = "insert into viagem (linha, destino, origem, data, preco)  values (?, ?, ?, ?, ?)";
    private static final String APAGAR_VIAGEM = "delete from viagem where linha = ?";
    private static final String BUSCAR_DESTINO = "select destino from viagem where linha = ?";
    private static final String ATUALIZAR_CADASTRO = "update viagem set preco = ?, destino = ?, origem = ?, data = ? where linha = ?";

    public List<Viagem> listarTodasViagens() {
        List<Viagem> ViagemCadastradas = new ArrayList<>();
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement comandoListar = conexao.prepareStatement(VIAGEM_CADASTRADAS);
            ResultSet resultado = comandoListar.executeQuery();
            while (resultado.next()) {
                Viagem viagem = new Viagem();
                viagem.setId(resultado.getInt("id"));
                viagem.setLinha(resultado.getInt("linha"));
                viagem.setDestino(resultado.getString("destino"));
                viagem.setOrigem(resultado.getString("origem"));
                viagem.setData(resultado.getString("data"));
                viagem.setPreco(resultado.getFloat("preco"));
                ViagemCadastradas.add(viagem);
            }
            conexao.close();
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return ViagemCadastradas;
    }
    
    public boolean cadastrarViagem(Viagem novaViagem) throws SQLException{
        
        // verifica se a viagem já está cadastrada;
        for(Viagem v: listarTodasViagens()){
            if(novaViagem.getLinha() == v.getLinha()){
                return false;
            }
        }
        
        try (Connection conexao = ConectaBanco.getConexao()) {
            PreparedStatement comandoCadastrar = conexao.prepareStatement(NOVA_VIAGEM);
            comandoCadastrar.setInt(1, novaViagem.getLinha());
            comandoCadastrar.setString(2,novaViagem.getDestino());
            comandoCadastrar.setString(3,novaViagem.getOrigem());
            comandoCadastrar.setString(4, novaViagem.getData());
            comandoCadastrar.setFloat(5, novaViagem.getPreco());
            
            comandoCadastrar.execute();
            conexao.close();
        }
        return true;
    }
    
    public boolean deletarViagem(int linha) throws SQLException{
        
        // apagar tiket ligados ao linha
        
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoDeletar = conexao.prepareStatement(APAGAR_VIAGEM);
        comandoDeletar.setInt(1,linha);
        comandoDeletar.execute();
        return true;
    }
    
    public String buscarDestino(int linha) throws SQLException{
        
        String destino = "";
        
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoBuscarNome = conexao.prepareStatement(BUSCAR_DESTINO);
        comandoBuscarNome.setInt(1, linha);
        ResultSet resultado = comandoBuscarNome.executeQuery();
        if(resultado.next()){
           destino = resultado.getString("destino");
        }
        conexao.close();
        return destino;
    }
    
    public void atualizaCadastroDaViagem(Viagem novosDados) throws SQLException{
        
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoAtualizar = conexao.prepareStatement(ATUALIZAR_CADASTRO);
        comandoAtualizar.setFloat(1, novosDados.getPreco());
        comandoAtualizar.setString(2, novosDados.getDestino());
        comandoAtualizar.setString(3,novosDados.getOrigem());
        comandoAtualizar.setString(4,novosDados.getData());
        
        // Linha não muda, ela está sendo usada como campo de busca;
        comandoAtualizar.setInt(5, novosDados.getLinha());
        
        comandoAtualizar.execute();
        conexao.close();
        
    }
    
}
