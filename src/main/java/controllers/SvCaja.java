package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CD;

/**
 *
 * @author Paula Vázquez Tella
 */
public class SvCaja extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        // Invalidar la sesión para borrar todos los datos
        session.invalidate();
        // Redirigir al usuario a index.html
        response.sendRedirect("index.html");
    }

}
