package models;

import util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sergio
 */
public class UsuarioDAO {

    // Consulta SQL para iniciar sesión 
    private static final String SQL_INICIAR_SESION = "select * from usuario where correoelectronico = ? and contrasena = ?";

    // Consulta SQL para insertar un nuevo usuario
    private static final String SQL_REGISTRARSE = "insert into usuario (correoelectronico, contrasena, tipotarjeta, numtarjeta) values (?, ?, ?, ?)";

    // Método para iniciar sesión 
    public Usuario iniciarSesion(String correoElectronico, String contrasena) {
        Usuario usuario = null;
        System.out.println(this.getClass().getName() + ": obteniendo conexion a la bd");

        try (Connection conexion = ConexionBD.obtenerConexion()) {
            PreparedStatement consulta;
            ResultSet resultado;

            System.out.println(this.getClass().getName() + ": conectado a la bd y preparando la consulta...");
            // Preparar la consulta SQL 
            consulta = conexion.prepareStatement(SQL_INICIAR_SESION);
            consulta.setString(1, correoElectronico);
            consulta.setString(2, contrasena);
            System.out.println(this.getClass().getName() + ": ejecutando consulta");
            // Ejecutar la consulta 
            resultado = consulta.executeQuery();
            // Procesar el resultado
            if (resultado.next()) {
                System.out.println(this.getClass().getName() + ": se ha encontrado un usuario");
                int id = resultado.getInt("id");
                String tipoTarjeta = resultado.getString("tipoTarjeta");
                String numTarjeta = resultado.getString("numTarjeta");
                usuario = new Usuario(id, correoElectronico, contrasena, tipoTarjeta, numTarjeta);
            }
        } catch (Exception e) {
            System.out.println(this.getClass().getName() + ": inicio de sesión fallido");
            System.out.println(e.getMessage());

        }

        return usuario;
    }

    // Método para registrar un nuevo usuario
    public int registrarse(Usuario usuario) {
        int id = -1;
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            PreparedStatement consulta;
            ResultSet resultado;

            // Preparar la consulta SQL
            consulta = conexion.prepareStatement(SQL_REGISTRARSE, Statement.RETURN_GENERATED_KEYS);

            consulta.setString(1, usuario.getCorreoElectronico());
            consulta.setString(2, usuario.getContrasena());
            consulta.setString(3, usuario.getTipoTarjeta());
            consulta.setString(4, usuario.getNumTarjeta());

            // Ejecutar la consulta
            int filasInsertadas = consulta.executeUpdate();
            // Verificar si se insertó correctamente
            if (filasInsertadas > 0) {
                resultado = consulta.getGeneratedKeys();
                if (resultado.next()) {
                    id = resultado.getInt(1);
                }
            }

        } catch (Exception e) {
            System.out.println(this.getClass().getName() + ": No se ha podido registrar el usuario");
            System.out.println(e.getMessage());
        }
        return id;
    }
}
