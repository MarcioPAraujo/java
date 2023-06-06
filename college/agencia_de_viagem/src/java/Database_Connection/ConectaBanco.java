/*

 */
package Database_Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MariaIlsa
 */
public class ConectaBanco {
    public static java.sql.Connection getConexao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           //com.mysql.cj.jdbc.Driver
           //com.mysql.jdbc.Driver
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_viagem","root","magicword_do");
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
}
