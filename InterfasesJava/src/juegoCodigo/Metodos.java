
package juegoCodigo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Metodos {

    //este metodo sirve para generar numeros aleatorios y se utilizara en los otros metodos
    public static int generarNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

    //este metodo sirve para mostrar una imagen dentro de un Jlabel en la interfaz grafica
    public static void mostrarImagen(JLabel lbl, String ruta) {

        lbl.setIcon(new ImageIcon(ruta));

    }

}
