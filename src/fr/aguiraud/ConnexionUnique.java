package fr.aguiraud;

import java.sql.*;

/**
 * Created by a14005704 on 14/10/15.
 */
public class ConnexionUnique {
    private Connection connection;
    private static final String CONNECT_URL = "jdbc:mysql://10.211.55.129:3306/GestionPedaBD";

    private ConnexionUnique() throws SQLException {
        this.connection = DriverManager.getConnection(CONNECT_URL, "root", "root");
    }

    private static ConnexionUnique INSTANCE = null;

    public static ConnexionUnique getInstance() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = new ConnexionUnique();
        }
        return INSTANCE;
    }

    public static String getLabel() {
        return "GestionPedaBD";
    }

    public Connection getConnection() {
        return connection;
    }


}
