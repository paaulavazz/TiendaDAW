/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Usuario implements Serializable{

    private String correoElectronico;
    private String contrasena;
    private String tipoTarjeta;
    private int numTarjeta;

    public Usuario() {
    }

    public Usuario(String correoElectronico, String contrasena, String tipoTarjeta, int numTarjeta) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
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

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

}
