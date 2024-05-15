package models;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Usuario implements Serializable {

    private int id;
    private String correoElectronico;
    private String contrasena;
    private String tipoTarjeta;
    private String numTarjeta;

    public Usuario() {
    }

    public Usuario(String correoElectronico, String contrasena, String tipoTarjeta, String numTarjeta) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
    }

    public Usuario(int id, String correoElectronico, String contrasena, String tipoTarjeta, String numTarjeta) {
        this.id = id;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

}
