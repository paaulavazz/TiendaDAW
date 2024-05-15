package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Pedido;
import models.PedidoDAO;
import models.Usuario;
import models.UsuarioDAO;

/**
 *
 * @author Paula Vázquez Tella
 */
public class SvCaja extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        System.out.println(this.getClass().getName() + ": accion=" + accion);
        if ("iniciarSesion".equals(accion)) {
            System.out.println(this.getClass().getName() + ": iniciando sesión");
            // Código para manejar el inicio de sesión
            String correoElectronico = request.getParameter("email");
            String contrasena = request.getParameter("password");

            // Validar las credenciales en la base de datos
            Usuario usuarioComprador = validarCredenciales(correoElectronico, contrasena);
            if (usuarioComprador != null) {

                System.out.println(this.getClass().getName() + ": sesión iniciada, se registrará el pedido");
                // El usuario ha iniciado sesión correctamente
                HttpSession session = request.getSession();
                Double importe = (Double) session.getAttribute("total");

                Pedido pedido = new Pedido(usuarioComprador, importe);
                int idPedido = almacenarPedido(pedido);
                if (idPedido > -1) {
                    System.out.println(this.getClass().getName() + ": pedido almacenado, pasando a la página de detalle");
                    pedido.setId(idPedido);
                    request.setAttribute("pedido", pedido);
                    session.setAttribute("usuario", usuarioComprador);
                    request.getRequestDispatcher("/WEB-INF/jsp/detalle.jsp").forward(request, response);
                } else {
                }
            } else {
                System.out.println(this.getClass().getName() + ": usario no encontrado, se procede al registro");
                // Las credenciales son incorrectas, redirigir a la página de registro
                request.getRequestDispatcher("/WEB-INF/jsp/registro.jsp").forward(request, response);
            }
        } else if ("cancelar".equals(accion)) {
            HttpSession session = request.getSession(false);

            // Invalidar la sesión para borrar todos los datos
            session.invalidate();
            // Redirigir al usuario a index.html
            response.sendRedirect("index.html");
        }
    }

    private Usuario validarCredenciales(String correoElectronico, String contrasena) {
        System.out.println(this.getClass().getName() + ": validando credenciales del usuario " + correoElectronico + " y contraseña " + contrasena);
        return usuarioDAO.iniciarSesion(correoElectronico, contrasena);
    }

    private int almacenarPedido(Pedido pedido) {
        System.out.println(this.getClass().getName() + ": almacenando pedido...");
        return pedidoDAO.registrarPedido(pedido);
    }

}
