package fr.aguiraud;

import java.sql.*;

/**
 * Created by a14005704 on 14/10/15.
 */
public class testConnexion {
    static final String req = "SELECT COUNT(*) FROM ENSEIGNT";
    public static void main(String[] args) throws SQLException {
        // Objet materialisant la connexion a la base de donnees
        Connection conn = null;
        try {
            // Connexion a la base
            ConnexionUnique Instance = ConnexionUnique.getInstance();
            conn = Instance.getConnection();
            System.out.println("Connecté à " + ConnexionUnique.getLabel());
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            if (rset.next()){
                System.out.print(rset.getInt(1));
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        } finally {
            if (conn != null) {
                // Deconnexion de la base de donnees
                conn.close();
            }
        }
    }

}
