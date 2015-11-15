package fr.aguiraud;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a14005704 on 22/10/15.
 */
public class Prof implements Serializable {
    private int numProf;
    private String nomProf;
    private String prenomProf;
    private String adrProf;
    private String cpProf;
    private String villeProf;
    private Module specialite;
    private Set<Enseignement> SEnseignt = new HashSet<>();

    public Prof(int numProf, String nomProf, String prenomProf, String adrProf, String cpProf, String villeProf, Module specialite) {
        this.numProf = numProf;
        this.nomProf = nomProf;
        this.prenomProf = prenomProf;
        this.adrProf = adrProf;
        this.cpProf = cpProf;
        this.villeProf = villeProf;
        this.specialite = specialite;
    }

    public Prof() {
        this(0, " ", " ", " ", " ", " ", null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prof prof = (Prof) o;

        if (numProf != prof.numProf) return false;
        if (nomProf != null ? !nomProf.equals(prof.nomProf) : prof.nomProf != null) return false;
        if (prenomProf != null ? !prenomProf.equals(prof.prenomProf) : prof.prenomProf != null) return false;
        if (adrProf != null ? !adrProf.equals(prof.adrProf) : prof.adrProf != null) return false;
        if (cpProf != null ? !cpProf.equals(prof.cpProf) : prof.cpProf != null) return false;
        return !(villeProf != null ? !villeProf.equals(prof.villeProf) : prof.villeProf != null);

    }

    @Override
    public int hashCode() {
        int result = numProf;
        result = 31 * result + (nomProf != null ? nomProf.hashCode() : 0);
        result = 31 * result + (prenomProf != null ? prenomProf.hashCode() : 0);
        result = 31 * result + (adrProf != null ? adrProf.hashCode() : 0);
        result = 31 * result + (cpProf != null ? cpProf.hashCode() : 0);
        result = 31 * result + (villeProf != null ? villeProf.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Prof{" +
                "numProf=" + numProf +
                ", nomProf='" + nomProf + '\'' +
                ", prenomProf='" + prenomProf + '\'' +
                ", adrProf='" + adrProf + '\'' +
                ", cpProf='" + cpProf + '\'' +
                ", villeProf='" + villeProf + '\'' +
                ", specialite='" + specialite.toString() +
                 '}';
    }

    public int getNumProf() {
        return numProf;
    }

    public void setNumProf(int numProf) {
        this.numProf = numProf;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
    }

    public String getAdrProf() {
        return adrProf;
    }

    public void setAdrProf(String adrProf) {
        this.adrProf = adrProf;
    }

    public String getCpProf() {
        return cpProf;
    }

    public void setCpProf(String cpProf) {
        this.cpProf = cpProf;
    }

    public String getVilleProf() {
        return villeProf;
    }

    public void setVilleProf(String villeProf) {
        this.villeProf = villeProf;
    }

    public Module getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Module specialite) {
        this.specialite = specialite;
    }

    public Set<Enseignement> getSEnseignt() {
        return SEnseignt;
    }

    public void setSEnseignt(Set<Enseignement> SEnseignt) {
        this.SEnseignt = SEnseignt;
    }

    public void addEnseignt(Enseignement ens) {
        SEnseignt.add(ens);
    }
}
