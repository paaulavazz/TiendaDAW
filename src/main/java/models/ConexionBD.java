package models;

import config.ConfigBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static Connection con = null;

    /**
     * @return conexion a la base de datos
     * @throws java.sql.SQLException
     */
    public static Connection obtenerConexion() throws SQLException {
        if (con == null) {

            // Get database credentials from DatabaseConfig class
            String jdbcUrl = ConfigBD.getDbUrl();
            String user = ConfigBD.getDbUsername();
            String password = ConfigBD.getDbPassword();

            // Open a connection
            con = DriverManager.getConnection(jdbcUrl, user, password);

        }

        return con;
    }

    public static void cerrarConexion() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
