package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Carrito implements Serializable {

    private List<CD> listaCDs;

    public Carrito() {
        listaCDs = new ArrayList<>();
    }

    public void agregarCD(CD cd) {
        listaCDs.add(cd);
    }

    public void eliminarCD(int indice) {
        listaCDs.remove(indice);
    }

    public List<CD> getListaCDs() {
        return listaCDs;
    }

    // Método para calcular el importe total del carrito
    public double calcularImporteTotal(Carrito carrito) {
        double total = 0.0;

        // Iterar sobre cada CD en el carrito y sumar el importe
        for (CD cd : listaCDs) {
            double importe = cd.getPrecio() * cd.getCantidad();
            total += importe;
        }

        return total;
    }

}
