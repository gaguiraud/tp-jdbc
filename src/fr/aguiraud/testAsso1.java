package fr.aguiraud;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by a14005704 on 14/10/15.
 */
public class testAsso1 {
    static final String req = "SELECT * FROM MODULE, PROF WHERE MODULE.CODE = PROF.MAT_SPEC";
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
            ArrayList<Prof> ListProf = new ArrayList<>();
            // Affichage du resultat
            while (rset.next()) {
                Module Mod = new Module();
                Mod.setCode(rset.getString("MAT_SPEC"));
                Mod.setLibelle(rset.getString("LIBELLE"));
                Prof prof = new Prof(rset.getInt("NUM_PROF"),
                                    rset.getString("NOM_PROF"),
                                    rset.getString("PRENOM_PROF"),
                                    rset.getString("ADR_PROF"),
                                    rset.getString("CP_PROF"),
                                    rset.getString("VILLE_PROF"),
                                    Mod);

                ListProf.add(prof);
                Mod.setResponsable(prof);
            }

            for (Prof prof : ListProf) {
                System.out.println(prof);
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
