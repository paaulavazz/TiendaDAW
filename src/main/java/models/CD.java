package models;

import java.io.Serializable;

/**
 *
 * @author Paula Vázquez Tella
 */
public class CD implements Serializable {
    private String nombre;
    private String artista;
    private String pais;
    private double precio;
    private int cantidad;

    public CD(String nombre, String artista, String pais, double precio, int cantidad) {
        this.nombre = nombre;
        this.artista = artista;
        this.pais = pais;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
