/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploconexionjdbc;

/**
 *
 * @author User
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EjemploConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario= "root";
        String password="";
        String url ="jdbc:mysql://localhost:3306/prueba";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // TODO code application logic here
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIO(USERNAME, USERPASSWORD) VALUES ('USUARIO4','CLAVE4')");
            rs = statement.executeQuery("SELECT * FROM USUARIO");
            rs.next();
            do{
                System.out.println(rs.getInt("userid") + " : "+rs.getString("username") );
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
