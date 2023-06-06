
package DAO_Classes;

import Classes.Tiket;
import Database_Connection.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TiketDAO {
    
    private static final String TIKET_CADASTRADOS = "select tiket.assento, tiket.fila, tiket.plataforma, tiket.prefixo, passageiro.nome, viagem.destino\n" +
"from viagem, passageiro, tiket\n" +
"where tiket.id_viagem = viagem.id and\n" + 
"	tiket.passageiro = passageiro.cpf;";
    
    private static final String NOVO_TIKET = "insert into tiket(assento, fila, plataforma, prefixo, passageiro, id_viagem) values( ?, ?, ?, ?, ?, (select id from viagem where linha = ?))";
    
    private static final String APAGAR_TIKET = "delete from tiket where passageiro = ? and id_viagem = (select id from viagem where linha = ?)";
    // apagar_tiket vai precisar do cpf e a linha da viagem para executar
    
    private static final String BUSCAR_TIKET = "select tiket.assento, tiket.fila, tiket.plataforma, tiket.prefixo, p.nome, viagem.destino\n" +
"from viagem, tiket inner join passageiro p on tiket.passageiro = p.cpf\n" +
"where p.cpf = ? and viagem.id = (select id from viagem where linha = ?)";
    // precisa do cpf do passagerio e linha do onibus
    
    private static final String ATUALIZAR_TIKET = "update tiket set assento = ?, fila = ?, plataforma = ?, prefixo = ? where passageiro = ? and id_viagem = (select id from viagem where linha = ?)";

    public List<Tiket> listarTiketsCadastrados(){
        List<Tiket> tiketsCadastrados = new ArrayList<>();
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement comandoListar = conexao.prepareStatement(TIKET_CADASTRADOS);
            ResultSet resultado = comandoListar.executeQuery();
            while (resultado.next()) {
                Tiket bilhete = new Tiket();
                bilhete.setAssento(resultado.getInt("assento"));
                bilhete.setFila(resultado.getString("fila"));
                bilhete.setPlataforma(resultado.getInt("plataforma"));
                bilhete.setPrefixo(resultado.getString("prefixo"));
                bilhete.setPassageiro(resultado.getString("passageiro.nome"));
                bilhete.setViagem(resultado.getString("viagem.destino"));
                tiketsCadastrados.add(bilhete);
            }
            conexao.close();
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return tiketsCadastrados;
    }
    
    public boolean cadastrarTiket(Tiket novoTiket, long cpf, int linha) throws SQLException{
        
        // validar se a data da viagem é igual, se for o bilhete é duplicado;
        
        try (Connection conexao = ConectaBanco.getConexao()) {
            PreparedStatement comandoCadastrar = conexao.prepareStatement(NOVO_TIKET);
            comandoCadastrar.setInt(1, novoTiket.getAssento());
            comandoCadastrar.setString(2,novoTiket.getFila());
            comandoCadastrar.setInt(3,novoTiket.getPlataforma());
            comandoCadastrar.setString(4, novoTiket.getPrefixo());
            comandoCadastrar.setLong(5,cpf);
            comandoCadastrar.setInt(6,linha);
            
            comandoCadastrar.execute();
            conexao.close();
        }
        return true;
    }
    
    public Tiket buscarTiket(long cpf, int linha) throws SQLException{
        
        Tiket bilhete = new Tiket();
        
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoBuscarBilhete = conexao.prepareStatement(BUSCAR_TIKET);
        comandoBuscarBilhete.setLong(1, cpf);
        comandoBuscarBilhete.setInt(2, linha);
        ResultSet resultado = comandoBuscarBilhete.executeQuery();
        if(resultado.next()){
           bilhete.setAssento(resultado.getInt("assento"));
           bilhete.setFila(resultado.getString("fila"));
           bilhete.setPlataforma(resultado.getInt("plataforma"));
           bilhete.setPrefixo(resultado.getString("prefixo"));
           bilhete.setPassageiro(resultado.getString("p.nome"));
           bilhete.setViagem(resultado.getString("viagem.destino"));
           
        }
        conexao.close();
        return bilhete;
    }
    
    public boolean deletarTiket(long cpf, int linha) throws SQLException{
        // numa deleção de passageiro ou viagem, o tiket relacionado a um dos dois deve ser o 1° a ser apagado;
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoDeletar = conexao.prepareStatement(APAGAR_TIKET);
        comandoDeletar.setLong(1,cpf);
        comandoDeletar.setInt(2, linha);
        comandoDeletar.execute();
        conexao.close();
        return true;
    }
    
    public void atualizarTiket(Tiket novosDados) throws SQLException{
        
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement comandoAtualizar = conexao.prepareStatement(ATUALIZAR_TIKET);
        comandoAtualizar.setInt(1, novosDados.getAssento());
        comandoAtualizar.setString(2, novosDados.getFila());
        comandoAtualizar.setInt(3,novosDados.getPlataforma());
        comandoAtualizar.setString(4,novosDados.getPrefixo());
        
        // passageiro e destino não mudam, estão sendo usados como campo de busca;
        comandoAtualizar.setString(5, novosDados.getPassageiro());
        comandoAtualizar.setString(6,novosDados.getViagem());
        
        comandoAtualizar.execute();
        conexao.close();
        
    }
}
