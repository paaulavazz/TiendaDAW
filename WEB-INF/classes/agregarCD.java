import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class agregarCD extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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

    }
}
