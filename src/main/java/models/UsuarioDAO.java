/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class UsuarioDAO {

    Connection conexion;
    ConexionBD conexionBD = new ConexionBD();
    PreparedStatement consulta;
    ResultSet resultado;

    // Consulta SQL para iniciar sesión 
    private static final String SQL_INICIAR_SESION = "select * from usuario where correoelectronico = ? and contrasena = ?";

    // Consulta SQL para insertar un nuevo usuario
    private static final String SQL_REGISTRARSE = "insert into usuario (correoelectronico, contrasena, tipotarjeta, numtarjeta) values (?, ?, ?, ?)";

    // Método para iniciar sesión 
    public Usuario iniciarSesion(String correoElectronico, String contrasena) {
        Usuario usuario = null;
        try {
            conexion = conexionBD.obtenerConexion();

            // Preparar la consulta SQL 
            consulta = conexion.prepareStatement(SQL_INICIAR_SESION);
            consulta.setString(1, correoElectronico);
            consulta.setString(2, contrasena);

            // Ejecutar la consulta 
            resultado = consulta.executeQuery();
            // Procesar el resultado
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String tipoTarjeta = resultado.getString("tipoTarjeta");
                String numTarjeta = resultado.getString("numTarjeta");
                usuario = new Usuario(id, correoElectronico, contrasena, tipoTarjeta, numTarjeta);
            }
        } catch (Exception e) {
        }
        return usuario;
    }

    // Método para registrar un nuevo usuario
    public int registrarse(Usuario usuario) {
        int id = -1;
        try {
            // Obtener una conexión del pool de conexiones
            conexion = conexionBD.obtenerConexion();

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
        }
        return id;
    }
}
