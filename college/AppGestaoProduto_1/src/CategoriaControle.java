
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author alunos
 */
public class CategoriaControle {
    
    public static List<String> listarCategorias() throws ClassNotFoundException, SQLException{
       
        List<String> lista = new ArrayList<>();
        CategoriaDAO dao = new CategoriaDAO();
        
        List<Categoria> itens = dao.listarTodas();
        
        for (Categoria c : itens ) {
            lista.add(c.getNome());
        }
        return lista;
    }
    
    
        
   
}
