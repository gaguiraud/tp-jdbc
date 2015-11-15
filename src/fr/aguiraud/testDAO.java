package fr.aguiraud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class testDAO {
    static final String req1 = "SELECT * FROM ETUDIANT WHERE ANNEE = 2";
    static final String req2 = "SELECT N.NUM_ET, N.CODE, MOY_CC, MOY_TEST"
                             + " FROM NOTATION N JOIN ETUDIANT E ON N.NUM_ET = E.NUM_ET"
                             + " JOIN MODULE M ON N.CODE = M.CODE "
                             + " WHERE ANNEE = 2 AND CODE = 'ACSI'";
    public static void main (String[] args) throws SQLException {

        Connection conn = null;
        DAOEtudiant DAOEt = DAOEtudiant.getInstance();
        DAOModule DAOMod = DAOModule.getInstance();
        DAONotation DAONote = DAONotation.getInstance();

        try {
            ConnexionUnique Instance = ConnexionUnique.getInstance();
            System.out.println( "Connexion a " + ConnexionUnique.getLabel()) ;
            conn = Instance.getConnection();
            System.out.println ( "Connecte \n" );

            Statement stmt = conn.createStatement();
            System.out.println("Execution de la requete : " + req1);
            ResultSet rset = stmt.executeQuery(req1);

            ArrayList<Etudiant> ALEtudiant = new ArrayList<>();

            while(rset.next()){
                ALEtudiant.add(DAOEt.getById(rset.getInt("NUM_ET")));
            }
            stmt.close();
            for(Etudiant e : ALEtudiant)
                System.out.println(e);

            ArrayList<Notation> ALNotation = new ArrayList<>();
            rset = stmt.executeQuery(req2);
            while(rset.next()){
                Notation Note = new Notation((rset.getFloat("MOY_TEST") + 1), (rset.getFloat("MOY_CC") + 1));
                Note.setEtudiant(DAOEt.getById(rset.getInt("N.NUM_ET")));
                Note.setModule(DAOMod.getById(rset.getString("N.CODE")));
                ALNotation.add(Note);
            }
            for(Notation N : ALNotation)
                DAONote.update(N);

        }
        catch ( SQLException e ) {
            e.printStackTrace() ; // Arggg!!!
            System.out.println(e. getMessage() + "\n" ) ;
        }

        finally {
            if ( conn != null ) {
                conn.close();
            }
        }
    }

}
