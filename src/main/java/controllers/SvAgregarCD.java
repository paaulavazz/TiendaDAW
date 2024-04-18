package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.http.HttpSession;

import models.CD;

/**
 *
 * @author Paula Vázquez Tella
 */
public class SvAgregarCD extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtenemos los parámetros del formulario
        String cdSeleccionado = request.getParameter("cd");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Creamos un StringTokenizer para dividir la cadena cdSeleccionado por el delimitador "|"
        StringTokenizer tokenizer = new StringTokenizer(cdSeleccionado, "|");

        String nombreCD = tokenizer.nextToken().trim(); // Nombre del CD
        String artistaCD = tokenizer.nextToken().trim(); // Artista del CD
        String paisCD = tokenizer.nextToken().trim(); // País del CD
        String precioString = tokenizer.nextToken().trim(); // Precio del CD

        double precio = Double.parseDouble(precioString.substring(1));
        
        // Creamos un objeto CD con la información seleccionada
        CD cd = new CD(nombreCD, artistaCD, paisCD, precio, cantidad); 

        // Almacenamos el objeto CD en el carrito de la compra
        HttpSession session = request.getSession(true);
        List<CD> carrito = (List<CD>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }
        carrito.add(cd);

        request.getRequestDispatcher("/WEB-INF/jsp/carritoCompra.jsp").forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
