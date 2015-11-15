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
public class DAOEnseignement {
    private static DAOEnseignement instance;
    private Connection conn;

    public Enseignement insert(Enseignement ens){
        final String req = "INSERT INTO ENSEIGNEMENT "
                + "VALUES (" + ens.getEtudiant().getNumEt() + ", "
                + ens.getModule().getCode() + ", "
                + ens.getProf().getNumProf() + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ens;
    }

    public boolean delete(Enseignement ens){
        final String req = "DELETE INTO Enseignement "
                + "WHERE NUM_ET = " + ens.getEtudiant().getNumEt()
                + " AND CODE = " + ens.getModule().getCode()
                + " AND NUM_PROF = " + ens.getProf().getNumProf();
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

    public boolean update(Enseignement ens){
        final String req = "UPDATE Enseignement "
                + "SET NUM_ET = " + ens.getEtudiant().getNumEt()
                + ", CODE = " + ens.getModule().getCode()
                + ", NUM_PROF = " + ens.getProf().getNumProf()
                + " WHERE NUM_ET = " + ens.getEtudiant().getNumEt()
                + " AND CODE = " + ens.getModule().getCode()
                + " AND NUM_PROF = " + ens.getProf().getNumProf();
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

    public Enseignement getById(int num_et, String code, int num_prof){
        final String req = "SELECT * FROM Enseignement WHERE CODE = " + code
                         +" AND NUM_ET = " + num_et
                         + " ANS NUM_PROF = " + num_prof;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            Enseignement ens = new Enseignement();
            DAOEtudiant DAOEt = DAOEtudiant.getInstance();
            DAOModule DAOMod = DAOModule.getInstance();
            DAOProf DAOPr = DAOProf.getInstance();
            ens.setEtudiant(DAOEt.getById(rset.getInt("NUM_ET")));
            ens.setModule(DAOMod.getById(rset.getString("CODE")));
            ens.setProf(DAOPr.getById(rset.getInt("NUM_PROF")));
            stmt.close();
            return ens;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Enseignement> findAll(){
        final String req = "SELECT * FROM ETUDIANT";
        List<Enseignement> ALEtu = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            DAOEtudiant DAOEt = DAOEtudiant.getInstance();
            DAOModule DAOMod = DAOModule.getInstance();
            DAOProf DAOPr = DAOProf.getInstance();
            while(rset.next()){
                Enseignement ens = new Enseignement();
                ens.setEtudiant(DAOEt.getById(rset.getInt("NUM_ET")));
                ens.setModule(DAOMod.getById(rset.getString("CODE")));
                ens.setProf(DAOPr.getById(rset.getInt("NUM_PROF")));
                ALEtu.add(ens);
            }
            stmt.close();
            return ALEtu;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ALEtu;
    }
    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public static DAOEnseignement getInstance(){
        if (instance == null)
            instance = new DAOEnseignement();
        return instance;
    }

}
