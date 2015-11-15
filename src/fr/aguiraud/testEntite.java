package fr.aguiraud;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by a14005704 on 14/10/15.
 */
public class testEntite {
    static final String req = "SELECT * as ctr FROM ETUDIANT";
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
            System.out.println("Execution de la requete : " + req);
            ResultSet rset = stmt.executeQuery(req);

            // Stockage du resultat dans un ArrayList
            ArrayList<Etudiant> listEtud = new ArrayList<>();
            int ctr = 0;
            Etudiant etudiant = null;
            while (rset.next()) {
                ctr = rset.getInt("ctr");
                etudiant = new Etudiant(rset.getInt("NUM_ET"), rset.getString("NOM_ET"), rset.getString("PRENOM_ET"), rset.getString("CP_ET"), rset.getString("VILLE_ET"), rset.getInt("ANNEE"), rset.getInt("GROUPE"));
                listEtud.add(etudiant);
            }

            // Affichage de tous les étudiants
            for (Etudiant etud : listEtud) {
                System.out.println(etud);
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
