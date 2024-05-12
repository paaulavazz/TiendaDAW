package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.http.HttpSession;

import models.CD;
import models.Carrito;

/**
 *
 * @author Paula Vázquez Tella
 */
public class SvAgregarCD extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los parámetros del formulario
        String cdSeleccionado = request.getParameter("cd");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Dividir la cadena cdSeleccionado por el delimitador "|"
        StringTokenizer tokenizer = new StringTokenizer(cdSeleccionado, "|");

        String nombreCD = tokenizer.nextToken().trim(); // Nombre del CD
        String artistaCD = tokenizer.nextToken().trim(); // Artista del CD
        String paisCD = tokenizer.nextToken().trim(); // País del CD
        String precioString = tokenizer.nextToken().trim(); // Precio del CD

        double precio = Double.parseDouble(precioString.substring(1));

        // Crear un objeto CD con la información seleccionada
        CD cd = new CD(nombreCD, artistaCD, paisCD, precio, cantidad);

        // Almacenar el objeto CD en el carrito de la compra
        HttpSession session = request.getSession(true);
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        carrito.agregarCD(cd);

        // Calcular el importe total del carrito
        Double total = carrito.calcularImporteTotal(carrito);
        // Pasar el importe total como atributo de la sesion
        session.setAttribute("total", total);

        // Redireccionar a la página de carritoCompra.jsp
        request.getRequestDispatcher("/WEB-INF/jsp/carritoCompra.jsp").forward(request, response);
    }
}
