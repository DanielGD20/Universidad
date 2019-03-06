/*
crear una clase bookmark que cree categorias, registre favoritos (crear, modificar, eliminar), añadir comentarios y fecha del comentario a un favorito
exportar los archivos a JSON
 */
package clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static controlador.Main.listaFavoritos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import ui.ventana1;

/**
 *
 * @author Anthony
 */

public class bookmark {

    private String nombreFavorito;
    private String url;
    private Date fechaDeRegistro;
    private String categoria;
    private comentario comentario;

    public bookmark() {

        this.nombreFavorito = null;
        this.categoria = null;
        this.url = null;
        this.fechaDeRegistro = new Date();
        this.comentario = null;

    }

    private int getNumeroRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public comentario getComentario() {
        return comentario;
    }

    public void setComentario(comentario comentario) {
        this.comentario = comentario;
    }

    

    public String getNombreFavorito() {
        return nombreFavorito;
    }

    public void setNombreFavorito(String nombreFavorito) {
        this.nombreFavorito = nombreFavorito;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public void crear(String nombre, String categoria, Date fecha, String url, comentario comentario) {
        this.setComentario(comentario);
        this.setNombreFavorito(nombre);
        this.setCategoria(categoria);
        this.setFechaDeRegistro(fecha);
        this.setUrl(url);
    }
    
    public void guardarEncuesta(File file) {
        PrintWriter writer = null;
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        try {
            writer = new PrintWriter(file);
            for (int i = 0; i < listaFavoritos.size(); i++) {
                writer.print(gsonPretty.toJson(listaFavoritos.get(i).getNombreFavorito())); 
                writer.print(gsonPretty.toJson(listaFavoritos.get(i).getCategoria()));
                writer.print(gsonPretty.toJson(listaFavoritos.get(i).getFechaDeRegistro()));
                writer.print(gsonPretty.toJson(listaFavoritos.get(i).getUrl()));
                writer.print(gsonPretty.toJson(listaFavoritos.get(i).getComentario()));
                writer.flush();
            }
        } catch (FileNotFoundException ex) {            
        } finally {
            // finally: siempre se ejecuta
            writer.close();
        }
    }
}
