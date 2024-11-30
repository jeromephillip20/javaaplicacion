/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
/**
 *
 * @author alexo
 */
public class Registro {

//    public static void registrar(JEditorPane txtCodigo, JEditorPane txtTitulo, JEditorPane txtDirector, String formato, JComboBox<String> botonCategoria, JEditorPane txtMinutosDuracion, boolean estreno) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
////    }

    String sql = "";

    public Registro() {
    }

   public static boolean actualizarDatos(int codigo, String titulo, String director, int minutosduracion, String formato, String categoria, boolean estreno) {
    String query = "UPDATE pelicula SET titulo=?, director=?, formato=?, categoria=?, duracion=?, estreno=? WHERE codigo=?";
    
    try (Connection connect = BD.ConexionBD.Obtenerconexion();
         PreparedStatement ps = connect.prepareStatement(query)) {
        ps.setString(1, titulo);
        ps.setString(2, director);
        ps.setString(3, formato);
        ps.setString(4, categoria);
        ps.setInt(5, minutosduracion);
        ps.setBoolean(6, estreno);
        ps.setInt(7, codigo);
        
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.err.println("Error en registro al actualizar datos: " + e.getMessage());
        
        return false;
    }
}
    
    public static boolean registrar(int codigo, String titulo, String director, String formato, String categoria, int minutosduracion, boolean estreno) throws SQLException {
        PreparedStatement ps = null;
        Connection connect = BD.ConexionBD.Obtenerconexion();
        String query = "INSERT INTO pelicula (codigo, titulo, director, formato, categoria, duracion, estreno) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connect.prepareStatement(query);
            ps.setInt(1, codigo);
            ps.setString(2, titulo);
            ps.setString(3, director);
            ps.setString(4, formato);
            ps.setString(5, categoria);
            ps.setInt(6, minutosduracion);
            ps.setBoolean(7, estreno);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                connect.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }
    
    
    
}
