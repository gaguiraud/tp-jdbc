package fr.aguiraud;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a14005704 on 22/10/15.
 */
public class Etudiant implements Serializable {
    private int numEt;
    private String nomEt;
    private String prenomEt;
    private String cpEt;
    private String villeEt;
    private int annee;
    private int groupe;
    private Set<Enseignement> SEnseignt = new HashSet<>();

    public Etudiant(int numEtu, String nomEtu, String prenomEtu, String cpEtu, String villeEtu, int anneeEtu, int groupeEtu) {
        numEt = numEtu;
        nomEt = nomEtu;
        prenomEt = prenomEtu;
        cpEt = cpEtu;
        villeEt = villeEtu;
        annee = anneeEtu;
        groupe = groupeEtu;
    }
    public Etudiant() {
        this(0, " ", " ", " ", " ", 0, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etudiant etudiant = (Etudiant) o;

        if (numEt != etudiant.numEt) return false;
        if (annee != etudiant.annee) return false;
        if (groupe != etudiant.groupe) return false;
        if (nomEt != null ? !nomEt.equals(etudiant.nomEt) : etudiant.nomEt != null) return false;
        if (prenomEt != null ? !prenomEt.equals(etudiant.prenomEt) : etudiant.prenomEt != null) return false;
        if (cpEt != null ? !cpEt.equals(etudiant.cpEt) : etudiant.cpEt != null) return false;
        return !(villeEt != null ? !villeEt.equals(etudiant.villeEt) : etudiant.villeEt != null);

    }

    @Override
    public int hashCode() {
        int result = numEt;
        result = 31 * result + (nomEt != null ? nomEt.hashCode() : 0);
        result = 31 * result + (prenomEt != null ? prenomEt.hashCode() : 0);
        result = 31 * result + (cpEt != null ? cpEt.hashCode() : 0);
        result = 31 * result + (villeEt != null ? villeEt.hashCode() : 0);
        result = 31 * result + annee;
        result = 31 * result + groupe;
        return result;
    }

    @Override
    public String toString() {
        return "Etudiant {" +

                "numEt = " + numEt +
                ", nomEt = '" + nomEt + '\'' +
                ", prenomEt = '" + prenomEt + '\'' +
                ", cpEt = '" + cpEt + '\'' +
                ", villeEt = '" + villeEt + '\'' +
                ", annee = " + annee +
                ", groupe = " + groupe +
                '}';
    }

    public int getNumEt() {
        return numEt;
    }

    public void setNumEt(int numEt) {
        this.numEt = numEt;
    }

    public String getNomEt() {
        return nomEt;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public String getPrenomEt() {
        return prenomEt;
    }

    public void setPrenomEt(String prenomEt) {
        this.prenomEt = prenomEt;
    }

    public String getCpEt() {
        return cpEt;
    }

    public void setCpEt(String cpEt) {
        this.cpEt = cpEt;
    }

    public String getVilleEt() {
        return villeEt;
    }

    public void setVilleEt(String villeEt) {
        this.villeEt = villeEt;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
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

