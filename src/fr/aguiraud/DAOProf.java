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
public class DAOProf {
    private static DAOProf instance;
    private Connection conn;

    public Prof insert(Prof prof){
        final String req = "INSERT INTO PROF "
                + "VALUES (" + prof.getNumProf() + ", "
                + prof.getNomProf()+ ", "
                + prof.getPrenomProf() + ", "
                + prof.getAdrProf() + ", "
                + prof.getCpProf() + ", "
                + prof.getVilleProf() + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }

    public boolean delete(Prof prof){
        final String req = "DELETE INTO PROF "
                + "WHERE NUM_PROF = " + prof.getNumProf();
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

    public boolean update(Prof prof){
        final String req = "UPDATE PROF "
                + "SET NUM_PROF = " + prof.getNumProf()
                + ", NOM_PROF = " + prof.getNomProf()
                + ", PRENOM_PROF = " + prof.getPrenomProf()
                + ", ADR_PROF = " + prof.getAdrProf()
                + ", CP_PROF = "  + prof.getCpProf()
                + ", VILLE_PROF = " + prof.getVilleProf()
                + " WHERE NUM_PROF = " + prof.getNumProf();
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

    public Prof getById(int num_prof){
        final String req = "SELECT * FROM PROF WHERE NUM_PROF = " + num_prof;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            Prof prof = new Prof();
            prof.setAdrProf(rset.getString("ADR_PROF"));
            prof.setCpProf(rset.getString("CP_PROF"));
            prof.setNomProf(rset.getString("NOM_PROF"));
            prof.setNumProf(rset.getInt("NUM_PROF"));
            prof.setPrenomProf(rset.getString("PRENOM_PROF"));
            prof.setVilleProf(rset.getString("VILLE_PROF"));
            stmt.close();
            return prof;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("null")
    public List<Prof> findAll(){
        final String req = "SELECT * FROM PROF";
        List<Prof> ALProf = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()){
                Prof prof = new Prof(rset.getInt("NUM_PROF"),
                                   rset.getString("NOM_PROF"),
                                   rset.getString("PRENOM_PROF"),
                                   rset.getString("ADR_PROF"),
                                   rset.getString("CP_PROF"),
                                   rset.getString("VILLE_PROF"),
                                   null);
                ALProf.add(prof);
            }
            stmt.close();
            return ALProf;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ALProf;
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public static DAOProf getInstance(){
        if (instance == null)
            instance = new DAOProf();
        return instance;
    }

}
