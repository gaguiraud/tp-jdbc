package fr.aguiraud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by a14005704 on 14/10/15.
 */
public class  testAsso2 {
    static final String req = "SELECT * FROM ETUDIANT, MODULE, NOTATION " +
                              "WHERE NOTATION.NUM_ET = ETUDIANT.NUM_ET " +
                              "AND NOTATION.CODE = MODULE.CODE";
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
            // Creation singleton
            AssociationNotation assoNot = AssociationNotation.getInstance();
            // Affichage du resultat
            while (rset.next()) {
                Prof prof = new Prof(/*rset.getInt("NUM_PROF"), rset.getString("NOM_PROF"), rset.getString("PRENOM_PROF"), rset.getString("ADR_PROF"), rset.getString("CP_PROF"), rset.getString("VILLE_PROF"), null*/);
                Module mod = new Module(rset.getString("CODE"),
                        rset.getString("LIBELLE"),
                        rset.getInt("H_COURS_PREV"),
                        rset.getInt("H_COURS_REA"),
                        rset.getInt("H_TP_PREV"),
                        rset.getInt("H_TP_REA"),
                        rset.getString("DISCIPLINE"),
                        rset.getInt("COEFF_TEST"),
                        rset.getInt("COEFF_CC"),
                        prof,
                        null);
                Etudiant etud = new Etudiant(rset.getInt("NUM_ET"),
                        rset.getString("NOM_ET"),
                        rset.getString("PRENOM_ET"),
                        rset.getString("CP_ET"),
                        rset.getString("VILLE_ET"),
                        rset.getInt("ANNEE"),
                        rset.getInt("GROUPE"));
                Notation note = new Notation(rset.getFloat("MOY_CC"), rset.getFloat("MOY_TEST"));
                assoNot.creerLien(mod, etud, note);
            }

            for (Lien lien : assoNot.getLiens()) {
                if (lien.getModule().getCode().equals("ACSI")) {
                    System.out.println(lien.toString());
                }
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
