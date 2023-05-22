
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alunos
 */
public class ProdutoDAO {
    /*criar metodo cadastrar prooduto retorno booleano e como parametro é um 
    objeto da classe produto
    ncluir no pacote modelo.dao a classe ProdutoDAO com os métodos List<Produto> listarTodos(), 
    que retorne uma lista de objetos produto com os produtos cadastrados no banco de
    dados e, boolean inserirProduto(Produto) que recebe um objeto da classe Produto e o cadastre no banco de dados, 
    retornando true caso a inclusão seja bem sucedida ou false caso contrário (produto já cadastrado);
    */
    private static final String LISTAR = "SELECT * from produtos";
    private static final String INSERIR = "insert into produtos(prod_nome,prod_categoria) values (?,?);";
    public List<Produto> listarProdutosCadastrados () {
    
        List<Produto> listaProduto = new ArrayList<>();
    
        try {
            Connection connection = ConectaBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(LISTAR);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Produto prod = new Produto(result.getInt("prod_id"), result.getString("prod_nome"), result.getInt("prod_categoria"));
                listaProduto.add(prod);
            }
            
            connection.close();
            statement.close();
        } catch (SQLException erro1) {
            throw new RuntimeException(erro1);
        } finally {
            
        }
        return listaProduto;
     
    }
    public boolean inserirProduto(Produto prod){
        
       
        for( Produto p : listarProdutosCadastrados()){
            if(prod.getNome().equals(p.getNome())){
                return false;
            }
        }
        
        
        try{
            Connection connection = ConectaBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(INSERIR);
            statement.setString(1,prod.getNome());
            statement.setInt(2,prod.getCategoria());
            statement.execute();
            statement.close();
            connection.close();
            return true;
        }
        catch(SQLException exception){
            exception.getMessage();
            return false;
        }
        finally{
            
        }
        
    }
}
