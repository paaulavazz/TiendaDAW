package models;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */

public class Carrito {
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
}