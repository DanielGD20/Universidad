/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardo
 */
public class sqlConnect {
    
    Connection cin = null;
    
    public static Connection ConnecrDB(){
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/ricardo/Desktop/DatabaseBookmark.db";
        //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    /**
     * Insert a new row into the warehouses table
     *
     * @param Nombre
     */
    public void insert(String Nombre) {
        String sql = "INSERT INTO Categoria(Nombre) VALUES(?)";
 
        try (Connection conn = this.ConnecrDB();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Nombre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void insert2(String Nombre, String URL, Date Fecha, String Comentario) {
        String sql = "INSERT INTO Favoritos(Nombre, URL, Fecha, Comentario) VALUES(?,?,?,?)";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = df.format(Fecha);
        
        try (Connection conn = this.ConnecrDB();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Nombre);
            pstmt.setString(2, URL);
            pstmt.setString(3, date);
            pstmt.setString(4, Comentario); 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
