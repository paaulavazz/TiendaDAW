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

/**
 *
 * @author sergio
 */
public class PedidoDAO {

    Connection conexion;
    ConexionBD conexionBD = new ConexionBD();
    PreparedStatement consulta;
    ResultSet resultado;

    // Consulta SQL para insertar un pedido
    private static final String SQL_INSERTAR_PEDIDO = "insert into pedido (usuariocomprador, importe) values (?,?)";

    public int registrarPedido(Pedido pedido) {
        int id = -1;
        try {
            conexion = conexionBD.obtenerConexion();

            // Preparar la consulta SQL 
            consulta = conexion.prepareStatement(SQL_INSERTAR_PEDIDO, Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, pedido.getUsuarioComprador().getId());
            consulta.setDouble(2, pedido.getImporte());

            int filasInsertadas = consulta.executeUpdate();
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
