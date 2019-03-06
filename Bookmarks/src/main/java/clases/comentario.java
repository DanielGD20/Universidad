
package clases;

import java.util.Date;

/**
 *
 * @author Anthony
 */

public class comentario {
    
    private String comentario;
    private Date fechaComentario;
    
    public comentario(){
        this.comentario = "";
        this.fechaComentario = new Date();
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
    
}
