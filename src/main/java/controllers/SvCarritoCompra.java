package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CD;
import models.Carrito;


public class SvCarritoCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if ("pagar".equals(accion)) {
            // Lógica para calcular el importe total
            double total = calcularImporteTotal(request); 

            // Pasar el importe total como atributo de solicitud
            request.setAttribute("total", total);

            // Redireccionar a la página de caja
            request.getRequestDispatcher("/WEB-INF/jsp/caja.jsp").forward(request, response);
        }
    }

    // Método para calcular el importe total
    private double calcularImporteTotal(HttpServletRequest request) {
        // Obtener el carrito de la sesión
        HttpSession session = request.getSession();
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        List<CD> listaCDs = carrito.getListaCDs();
        double total = 0.0;

        // Iterar sobre cada CD en el carrito
        for (CD cd : listaCDs) {
            double importe = cd.getPrecio() * cd.getCantidad();
            total += importe;
        }

        return total;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verificar si se ha enviado la solicitud de eliminación
        String eliminarBtn = request.getParameter("eliminarBtn");
        if ("eliminar".equals(eliminarBtn)) {
            // Obtener el índice del CD a eliminar
            int indiceEliminar = Integer.parseInt(request.getParameter("eliminar"));

            // Obtener el carrito de la sesión
            HttpSession session = request.getSession();
            Carrito carrito = (Carrito) session.getAttribute("carrito");

            // Eliminar el CD del carrito
            carrito.eliminarCD(indiceEliminar);
        }

        // Volver a cargar la página del carrito usando forward en lugar de sendRedirect
        request.getRequestDispatcher("/WEB-INF/jsp/carritoCompra.jsp").forward(request, response);
    }


}
