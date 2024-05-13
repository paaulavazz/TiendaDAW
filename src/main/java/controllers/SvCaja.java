package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CD;
import models.Pedido;
import models.PedidoDAO;
import models.Usuario;
import models.UsuarioDAO;

/**
 *
 * @author Paula Vázquez Tella
 */
public class SvCaja extends HttpServlet {

    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Invalidar la sesión para borrar todos los datos
        session.invalidate();
        // Redirigir al usuario a index.html
        response.sendRedirect("index.html");
    }

    private boolean validarCredenciales(String correoElectronico, String contrasena) {
        Usuario usuario = usuarioDAO.iniciarSesion(correoElectronico, contrasena);
        return usuario != null;
    }

    private boolean registrarUsuario(String correoElectronico, String contrasena, String tipoTarjeta, String numTarjeta) {
        Usuario usuario = new Usuario(correoElectronico, contrasena, tipoTarjeta, numTarjeta);
        int id = usuarioDAO.registrarse(usuario);
        usuario.setId(id);
        return id > -1;
    }

    private boolean almacenarPedido(Usuario usuarioComprador, double importe) {
        Pedido pedido = new Pedido(usuarioComprador, importe);
        int id = pedidoDAO.registrarPedido(pedido);
        pedido.setId(id);
        return id > -1;
    }

}
