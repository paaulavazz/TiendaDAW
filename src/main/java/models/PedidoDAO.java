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
public class PedidoDAO {

    // Consulta SQL para insertar un pedido
    private static final String SQL_INSERTAR_PEDIDO = "insert into pedido (usuariocomprador, importe) values (?,?)";

    public int registrarPedido(Pedido pedido) {
        int id = -1;

        System.out.println(this.getClass().getName() + ": obteniendo conexion a la bd");
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            PreparedStatement consulta;
            ResultSet resultado;

            System.out.println(this.getClass().getName() + ": conectado a la bd y preparando la consulta...");
            // Preparar la consulta SQL 
            consulta = conexion.prepareStatement(SQL_INSERTAR_PEDIDO, Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, pedido.getUsuarioComprador().getId());
            consulta.setDouble(2, pedido.getImporte());

            System.out.println(this.getClass().getName() + ": ejecutando consulta");
            int filasInsertadas = consulta.executeUpdate();
            if (filasInsertadas > 0) {

                System.out.println(this.getClass().getName() + ": se ha realizado al menos una insercion");
                resultado = consulta.getGeneratedKeys();
                if (resultado.next()) {
                    id = resultado.getInt(1);
                    System.out.println(this.getClass().getName() + ": id_new_user=" + id);
                }
            }

        } catch (Exception e) {
            System.out.println(this.getClass().getName() + ": No se ha podido almacenar el pedido");
            System.out.println(e.getMessage());
        }
        return id;
    }
}
