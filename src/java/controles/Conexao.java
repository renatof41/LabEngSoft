/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import org.jboss.logging.Logger;

/**
 *
 * @author marcello
 */
public class Conexao {
    private Connection con;
    
    public Conexao(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            
        } catch (Exception e) {
            Logger.getLogger(Conexao.class.getName()).log(Logger.Level.FATAL, e.getMessage(), e);
        }
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancovet?useUnicode=true&characterEncoding=UTF-8","root","1234");
        } catch (Exception e) {
            Logger.getLogger(Conexao.class.getName()).log(Logger.Level.FATAL, e.getMessage(), e);
        }
    }
    
    public Connection getConexao(){
        return con;
    }
    
}
