package models;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Pedido implements Serializable {

    private int id;
    private Usuario usuarioComprador;
    private double importe;

    public Pedido() {

    }

    public Pedido(Usuario usuarioComprador, double importe) {
        this.usuarioComprador = usuarioComprador;
        this.importe = importe;
    }

    public Pedido(int id, Usuario usuarioComprador, double importe) {
        this.id = id;
        this.usuarioComprador = usuarioComprador;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(Usuario usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
