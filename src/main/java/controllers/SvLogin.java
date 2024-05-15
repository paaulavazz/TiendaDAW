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
 * @author sergio
 */
public class SvLogin extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correoElectronico = request.getParameter("email");
        String contrasena = request.getParameter("password");
        String tipoTarjeta = request.getParameter("tipoTarjeta");
        String numTarjeta = request.getParameter("numeroTarjeta");

        Usuario usuarioComprador = new Usuario(correoElectronico, contrasena, tipoTarjeta, numTarjeta);
        System.out.println("registrando usuario");
        int id = registrarUsuario(usuarioComprador);
        if (id > -1) {
            usuarioComprador.setId(id);
            System.out.println("usuario registrado ");
            HttpSession session = request.getSession();
            Double importe = (Double) session.getAttribute("total");
            Pedido pedido = new Pedido(usuarioComprador, importe);
            System.out.println("nuevo pedido");
            int idPedido = almacenarPedido(pedido);
            if (idPedido > -1) {
                System.out.println("Pedido añadido");
                pedido.setId(idPedido);
                request.setAttribute("pedido", pedido);
                session.setAttribute("usuario", usuarioComprador);
                request.getRequestDispatcher(
                        "/WEB-INF/jsp/detalle.jsp").forward(request, response);
            }
        }
    }

    private int registrarUsuario(Usuario usuario) {
        return usuarioDAO.registrarse(usuario);
    }

    private int almacenarPedido(Pedido pedido) {
        return pedidoDAO.registrarPedido(pedido);
    }
}
