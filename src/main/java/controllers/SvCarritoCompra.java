package controllers;



import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.CD;


public class SvCarritoCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);

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
        List<CD> carrito = (List<CD>) request.getSession().getAttribute("carrito");
        double total = 0.0;

        // Iterar sobre cada CD en el carrito
        if (carrito != null) {
            for (CD cd : carrito) {
                double importe = cd.getPrecio() * cd.getCantidad();
                total += importe;
            }
        }

        return total;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        // Verifica si se ha enviado la solicitud de eliminación
        String eliminarBtn = request.getParameter("eliminarBtn");
        if ("eliminar".equals(eliminarBtn)) {
            // Obtiene el índice del CD a eliminar
            int indiceEliminar = Integer.parseInt(request.getParameter("eliminar"));

            // Obtiene el carrito de la sesión
            List<CD> carrito = (List<CD>) request.getSession().getAttribute("carrito");

            // Verifica si el índice está dentro del rango válido
            if (indiceEliminar >= 0 && indiceEliminar < carrito.size()) {
                // Elimina el CD del carrito
                carrito.remove(indiceEliminar);
            }
        }

        // Vuelve a cargar la página del carrito usando forward en lugar de sendRedirect
        request.getRequestDispatcher("/WEB-INF/jsp/carritoCompra.jsp").forward(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
