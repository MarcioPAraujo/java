
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 posicionando-a no pacote útil. Esta classe fará a
conexão com um banco de dados MySQL que deverá ser criado antes que a aplicação possa ser testada. 
Supõe-se que o banco de dados se chame dbloja e que o servidor MySQL atenda na porta 3302. Caso não seja esta 
a configuração usada nas aulas de implementação, ajustes serão necessários no código proposto O código-fonte da 
classe ConectaBanco deve incluir um
método estático chamado obtemConexao() que retorna uma conexão, e deve ser semelhante ao mostrado na Figura 3.
 */

/**
 *
 * @author alunos
 */
public class ConectaBanco {
    public static java.sql.Connection getConexao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           //com.mysql.cj.jdbc.Driver
           //com.mysql.jdbc.Driver
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja","root","magicword_do");
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
}
