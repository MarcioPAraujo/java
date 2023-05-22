/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alunos
 */
public class ProdutoControle {
    
   public boolean inserirProduto(String[] dados){
       /*
        dados[0] = nome da categoria;
        dados[1] = nome do produto;
       */
       int idCategoria = 0;
       
       
       //solicitar à classe categoriaControle que retorne o id da categoria cujo nome é passado como parâmetro.
       
       CategoriaDAO categoria = new CategoriaDAO();
       idCategoria = categoria.buscarIdDeCategoria (dados[0]);
       if (idCategoria == 0) {
           return false;
       }
       else{
            //Depois deve instanciar um objeto da classe produto e preencher seu nome e sua categoria
            Produto produto = new Produto();
            produto.setCategoria(idCategoria);
            produto.setNome(dados[1]);

            //Depois deve invocar o método inserirProduto da classe ProdutoDAO, passando a ele o objeto produto semipreenchido.
            ProdutoDAO prodDAO = new ProdutoDAO();
            
            return prodDAO.inserirProduto(produto);
            
       }
   }
       
       
}
