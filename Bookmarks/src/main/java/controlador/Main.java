package controlador;

import clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ui.*;

/**
 *
 * @author Anthony
 */

public class Main extends javax.swing.JFrame {
    
   
    

    public static ventana1 ventana1 = new ventana1();
    public static ventana2 ventana2 = new ventana2();
    public static ventana3 ventana3 = new ventana3();
    public static ventana4 ventana4 = new ventana4();
    public static ArrayList<String> categorias = new ArrayList();
    public static ArrayList<bookmark> listaFavoritos = new ArrayList();
    public static int guardarIndex = 0;

    public static void main(String[] args) {

        ventana1.setVisible(true);
        
    }

    public static void iterarCategorias() {
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println(categorias.get(i));
        }
    }
    
    public static void iterarListaFavoritos(){
        for (int i = 0; i < listaFavoritos.size(); i++) {
            System.out.println(listaFavoritos.get(i).getNombreFavorito());
        }
    }
}
