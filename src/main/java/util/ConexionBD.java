package util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author sergio
 */
public class ConexionBD {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:postgresql://localhost:5432/tienda");
        ds.setUsername("postgres");
        ds.setPassword("purple");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return ds.getConnection();
    }

    private ConexionBD() {
    }

}
