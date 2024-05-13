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

            // Obtener el carrito de la sesión
            HttpSession session = request.getSession();
            Carrito carrito = (Carrito) session.getAttribute("carrito");

            // Redireccionar a la página de caja
            if (!carrito.getListaCDs().isEmpty()) {
                request.getRequestDispatcher("/WEB-INF/jsp/caja.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher(
                        "/WEB-INF/jsp/carritoCompra.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verificar si se ha enviado la solicitud de eliminación
        String eliminarBtn = request.getParameter("eliminarBtn");
        if ("eliminar".equals(eliminarBtn)) {
            // Obtener el índice del CD a eliminar si se ha seleccionado un CD

            String indiceEliminarStr = request.getParameter("eliminar");
            if (indiceEliminarStr != null && !indiceEliminarStr.isEmpty()) {
                int indiceEliminar = Integer.parseInt(indiceEliminarStr);

                // Obtener el carrito de la sesión
                HttpSession session = request.getSession();
                Carrito carrito = (Carrito) session.getAttribute("carrito");

                // Verificar si el índice está dentro del rango de CDs en el carrito
                if (indiceEliminar >= 0 && indiceEliminar < carrito.getListaCDs().size()) {
                    // Eliminar el CD del carrito
                    carrito.eliminarCD(indiceEliminar);
                    Double total = carrito.calcularImporteTotal(carrito);
                    session.setAttribute("total", total);

                }
            }
        }

        // Volver a cargar la página del carrito usando forward en lugar de sendRedirect
        request.getRequestDispatcher(
                "/WEB-INF/jsp/carritoCompra.jsp").forward(request, response);
    }

}
