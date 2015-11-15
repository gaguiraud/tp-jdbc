package fr.aguiraud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a14005704 on 14/10/15.
 */
public class DAOEtudiant {
    private static DAOEtudiant instance;
    private Connection conn;

    public Etudiant insert(Etudiant etudiant){
        final String req = "INSERT INTO ETUDIANT "
                         + "VALUES (" + etudiant.getNumEt() + ", "
                         + etudiant.getNomEt() + ", "
                         + etudiant.getPrenomEt() + ", "
                         + etudiant.getCpEt() + ", "
                         + etudiant.getVilleEt() + ", "
                         + etudiant.getAnnee() + ", "
                         + etudiant.getGroupe() + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }

    public boolean delete(Etudiant etudiant){
        final String req = "DELETE INTO ETUDIANT "
                + "WHERE NUM_ET = " + etudiant.getNumEt();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Etudiant etudiant){
        final String req = "UPDATE ETUDIANT "
                + "SET NUM_ET = " + etudiant.getNumEt()
                + ", NOM_ET = "+ etudiant.getNomEt()
                + ", PRENOM_ET = " + etudiant.getPrenomEt()
                + ", CP_ET = " + etudiant.getCpEt()
                + ", VILLE_ET = " + etudiant.getVilleEt()
                + ", ANNEE = " + etudiant.getAnnee()
                + ", GROUPE = " + etudiant.getGroupe()
                + " WHERE NUM_ET = " + etudiant.getNumEt();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Etudiant getById(int num_et){
        final String req = "SELECT * FROM ETUDIANT WHERE NUM_ET = " + num_et;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            Etudiant etudiant = new Etudiant();
            etudiant.setAnnee(rset.getInt("ANNEE"));
            etudiant.setCpEt(rset.getString("CP_ET"));
            etudiant.setGroupe(rset.getInt("GROUPE"));
            etudiant.setNomEt(rset.getString("NOM_ET"));
            etudiant.setNumEt(rset.getInt("NUM_ET"));
            etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
            etudiant.setVilleEt(rset.getString("VILLE_ET"));
            stmt.close();
            return etudiant;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Etudiant> findAll(){
        final String req = "SELECT * FROM ETUDIANT";
        List<Etudiant> ALEtu = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()){
                ALEtu.add(new Etudiant(rset.getInt("NUM_ET"),
                        rset.getString("NOM_ET"),
                        rset.getString("PRENOM_ET"),
                        rset.getString("CP_ET"),
                        rset.getString("VILLE_ET"),
                        rset.getInt("ANNEE"),
                        rset.getInt("GROUPE")));
            }
            stmt.close();
            return ALEtu;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ALEtu;
    }

    public List<Etudiant> findByNom(String nom){
        final String req = "SELECT * FROM ETUDIANT WHERE NOM_ET = " + nom.toUpperCase();
        List<Etudiant> ALEtu = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                ALEtu.add(etudiant);
            }
            stmt.close();
            return ALEtu;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ALEtu;
    }

    public List<Etudiant> findByGroupe(int groupe){
        final String req = "SELECT * FROM ETUDIANT WHERE GROUPE = " + groupe;
        List<Etudiant> ALEtu = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                ALEtu.add(etudiant);
            }
            stmt.close();
            return ALEtu;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ALEtu;
    }

    public List<Etudiant> findByAnnee(int annee){
        final String req = "SELECT * FROM ETUDIANT WHERE ANNEE = " + annee;
        List<Etudiant> ALEtu = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                ALEtu.add(etudiant);
            }
            stmt.close();
            return ALEtu;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ALEtu;
    }

    public float computeMoyennePonderee(Etudiant etu){
        final String req = "SELECT MOY_TEST "
                         + "FROM NOTATION "
                         + "WHERE NUM_ETU = " + etu.getNumEt();
        float Moy = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            List<Float> Moyennes = new ArrayList<Float>();
            while(rset.next()){
                Moyennes.add(rset.getFloat("MOY_TEST"));
            }

            for(float Moyenne : Moyennes) Moy += Moyenne;

            if (Moyennes.size() != 0) Moy /= Moyennes.size();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Moy;
    }

    public int computeNbEtudiant(){
        final String req = "SELECT COUNT(*) AS CTR"
                         + "FROM ETUDIANT";
        int NbEtudiant = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            NbEtudiant = rset.getInt("CTR");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return NbEtudiant;
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public static DAOEtudiant getInstance(){
        if (instance == null)
            instance = new DAOEtudiant();
        return instance;
    }

}
