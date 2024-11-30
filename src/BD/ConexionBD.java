
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection Obtenerconexion() {

        Connection Conexionsita = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Conexionsita = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/filmtheaterdb", "root", "");

            System.out.println("EXITO en la conexion a base de datos!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR en la conexion a la base de datos");

        }
        return Conexionsita;

    }



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    private static final String URL = "jdbc:mysql://localhost:3306/FilmTheaterBD";
//    private static final String USUARIO = "root";
//    private static final String CONTRASENA = "";
//
////    public static Connection obtenerConexion() throws SQLException {
////        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
////    }
//    
//    public Connection obtenerConexion(){
//        
//        
//
//    
//        try {
//            
//            
//            
//                conexion = DriverManager.getConnection(url);
//            
//            
//            System.out.println("Conexion Exitosa!");
//            
//            
//            
//        } catch (Exception e) {
//            
//            System.out.println("Error en la conexion");
//            
//        }
//    
//        
//        
//    
//    }
//    
//    
//    
//            
//            
//            
}