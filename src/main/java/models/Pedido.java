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
public class Pedido implements Serializable {

    private double importe;
    private Usuario usuarioComprador;

    public Pedido() {

    }

    public Pedido(double importe, Usuario usuarioComprador) {
        this.importe = importe;
        this.usuarioComprador = usuarioComprador;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Usuario getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(Usuario usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

}
