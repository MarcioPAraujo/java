
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import java.util.*;

//@author alunos
public class CategoriaDAO {

    private static final String LISTAR = "SELECT * from categorias";
     private static final String BUSCA = "SELECT categ_id FROM categorias where categ_nome = ?";
     
    public List<Categoria> listarTodas() {

        List<Categoria> categs = new ArrayList<Categoria>();
        try {
            Connection connection = ConectaBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(LISTAR);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Categoria cat = new Categoria(result.getInt("categ_id"), result.getString("categ_nome"));
                categs.add(cat);
            }
            connection.close();
            statement.close();
        } catch (SQLException erro1) {
            throw new RuntimeException(erro1);
        } finally {
            
        }
        return categs;
    }

/*incluir na classe CategoriaDAO um método int buscarId(String nome)
          que receba o nome de uma categoria e retorne o id dessa categoria;*/

    public int buscarIdDeCategoria(String nome){
        int id=0;
        try {
            Connection connection = ConectaBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(BUSCA);
            statement.setString(1, nome);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt("categ_id");
            }
            connection.close();
            return id;
        } catch (SQLException exception) {
            exception.getMessage();
        }
        // retorna zero se a busca é feita com uma categoria inexistente;
        return 0;

    }
}