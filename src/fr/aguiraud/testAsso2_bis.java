package fr.aguiraud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a14005704 on 14/10/15.
 */
public class testAsso2_bis {
    static final String req = "SELECT ANNEE, ET.NUM_ET, P.NUM_PROF, PRENOM_PROF, NOM_PROF, M.CODE, LIBELLE "
                            + "FROM ENSEIGNT E JOIN ETUDIANT ET ON E.NUM_ET = ET.NUM_ET "
                            + 					  "JOIN MODULE M ON M.CODE = E.CODE "
                            +                     "JOIN PROF P ON P.NUM_PROF = E.NUM_PROF";
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
            ArrayList<Enseignement> ALEnseignt = new ArrayList<>();
            // Affichage du resultat
            while (rset.next()) {
                // Déclaration des parametres de l'enseignement
                Enseignement ens = new Enseignement();
                Etudiant etudiant = new Etudiant();
                Module mod = new Module();
                Prof prof = new Prof();

                // Remplissage des informations nécessaires
                etudiant.setNumEt(rset.getInt("ET.NUM_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                mod.setCode(rset.getString("CODE"));
                mod.setLibelle(rset.getString("LIBELLE"));
                prof.setNumProf(rset.getInt("NUM_PROF"));
                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
                prof.setNomProf(rset.getString("NOM_PROF"));

                // Initialisation enseignement
                ens.setEtudiant(etudiant);
                ens.setModule(mod);
                ens.setProf(prof);

                // Ajout enseignement aux parametres (association)
                etudiant.addEnseignt(ens);
                prof.addEnseignt(ens);

                // Ajout de l'enseignement à l'ArrayList
                ALEnseignt.add(ens);
            }

            Set<Enseignement> EnsPremAnnee = new HashSet<>();
            for(Enseignement ens : ALEnseignt){
                if(ens.getEtudiant().getAnnee() == 1){
                    EnsPremAnnee.add(ens);
                }
            }
            for(Enseignement ens : EnsPremAnnee) {
                System.out.println("Module : " + ens.getModule().getCode() + " (" + ens.getModule().getLibelle()
                        + "), Prof n° " + ens.getProf().getNumProf() + " (" + ens.getProf().getPrenomProf() + " " + ens.getProf().getNomProf() +")");
            }

            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk, deconnection.\n");
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
