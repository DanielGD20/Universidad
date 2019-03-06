
import clases.bookmark;
import clases.comentario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import org.junit.Test;

/**
 *
 * @author Anthony
 */
public class testCategorias {

    public testCategorias() {
    }

    @Test
    public void probarCategoriasIngresadas() {
        
        ArrayList<bookmark> listaFavoritos = new ArrayList();
        bookmark listado = new bookmark();
        comentario comentario = new comentario();
        String valor = null;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese los valores de los favoritos: ");
        System.out.println("Ingrese la categoria: ");
        valor = sc.nextLine();
        listado.setCategoria(valor);
        System.out.println("Ingrese el nombre del favorito: ");
        valor = sc.nextLine();
        listado.setNombreFavorito(valor);
        System.out.println("Ingrese el url de la pagina del favorito: ");
        valor = sc.nextLine();
        System.out.println("Ingrese el comentario: ");
        comentario.setComentario(valor);
        listado.setComentario(comentario);
        
        listaFavoritos.add(listado);
        System.out.println("\n");
        
        System.out.println("-------------Inicio de la iteracion------------\n");
            for (int i = 0; i < listaFavoritos.size(); i++) {
                System.out.println("------------- [ " + i + " ] ------------\n");
                System.out.println("Categoria: " + listaFavoritos.get(i).getCategoria());
                System.out.println("Comentario: " + listaFavoritos.get(i).getComentario().getComentario());
                System.out.println("Fecha de Registro: " + listaFavoritos.get(i).getFechaDeRegistro());
                System.out.println("Nombre del favorito: " + listaFavoritos.get(i).getNombreFavorito());
                System.out.println("Url registrado: " + listaFavoritos.get(i).getUrl());
            }
        
    }
}
