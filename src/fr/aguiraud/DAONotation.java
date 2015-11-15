package fr.aguiraud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAONotation {
    private static DAONotation Instance;
    private Connection conn;

    public DAONotation(){

    }

    public Notation insert(Notation note){
        final String req = "INSERT INTO NOTATION "
                + "VALUES (" + note.getEtudiant().getNumEt() + ", "
                + note.getModule().getCode() + ", "
                + note.getMoyCC() + ", "
                + note.getMoyTest() + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }

    public boolean delete(Notation note){
        final String req = "DELETE INTO NOTATION "
                + "WHERE NUM_ET = " + note.getEtudiant().getNumEt()
                + " AND CODE = " + note.getModule().getCode();
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

    public boolean update(Notation note){
        final String req = "UPDATE Notation "
                + "SET NUM_ET = " + note.getEtudiant().getNumEt()
                + ", CODE = " + note.getModule().getCode()
                + ", MOY_CC = " + note.getMoyCC()
                + ", MOY_TEST = " + note.getMoyTest()
                + " WHERE NUM_ET = " + note.getEtudiant().getNumEt()
                + " AND CODE = " + note.getModule().getCode();

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

    public Notation getById(int num_et, String code){
        final String req = "SELECT * FROM NOTATION WHERE CODE = " + code
                +" AND NUM_ET = " + num_et;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            Notation note = new Notation();
            DAOEtudiant DAOEt = DAOEtudiant.getInstance();
            DAOModule DAOMod = DAOModule.getInstance();
            note.setEtudiant(DAOEt.getById(rset.getInt("NUM_ET")));
            note.setModule(DAOMod.getById(rset.getString("CODE")));
            note.setMoyCC(rset.getFloat("MOY_CC"));
            note.setMoyTest(rset.getFloat("MOY_TEST"));
            stmt.close();
            return note;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("null")
    public List<Notation> findAll(){
        final String req = "SELECT * FROM NOTATION";
        List<Notation> ALNotation = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            DAOEtudiant DAOEt = DAOEtudiant.getInstance();
            DAOModule DAOMod = DAOModule.getInstance();
            while(rset.next()){
                Notation note = new Notation();
                note.setEtudiant(DAOEt.getById(rset.getInt("NUM_ET")));
                note.setModule(DAOMod.getById(rset.getString("CODE")));
                note.setMoyCC(rset.getFloat("MOY_CC"));
                note.setMoyTest(rset.getFloat("MOY_TEST"));
                ALNotation.add(note);
            }
            stmt.close();
            return ALNotation;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ALNotation;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public static DAONotation getInstance(){
        if (Instance == null)
            Instance = new DAONotation();
        return Instance;
    }
}
