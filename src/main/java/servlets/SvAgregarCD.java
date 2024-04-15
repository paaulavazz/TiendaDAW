package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author Paula Vázquez Tella
 */
public class SvAgregarCD extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtenemos los parámetros del formulario
        String cdSeleccionado = request.getParameter("cd");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Recuperamos información del precio del CD
        StringTokenizer t = new StringTokenizer(cdSeleccionado,"|");
        t.nextToken(); // Saltamos el primer token (nombre del CD)
        t.nextToken(); // Saltamos el segundo token (artista del CD)
        t.nextToken(); // Saltamos el tercer token (país del CD)
        String precioString = t.nextToken().trim(); // Obtenemos el precio del CD
        double precio = Double.parseDouble(precioString.substring(1)); // Eliminamos el signo "$" y convertimos a double
        
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
