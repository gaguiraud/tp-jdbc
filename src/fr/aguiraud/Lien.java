package fr.aguiraud;

/**
 * Created by guillaumeaguiraud on 30/10/15.
 */
public class Lien {
    private Module module;
    private Etudiant etudiant;
    private Notation note;

    public Lien(Module module, Etudiant etudiant) {
        this.module = module;
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "Lien{" +
                "module=" + module.toString() +
                ", etudiant=" + etudiant.toString() +
                ", note=" + note.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lien lien = (Lien) o;

        if (module != null ? !module.equals(lien.module) : lien.module != null) return false;
        return !(etudiant != null ? !etudiant.equals(lien.etudiant) : lien.etudiant != null);

    }

    @Override
    public int hashCode() {
        int result = module != null ? module.hashCode() : 0;
        result = 31 * result + (etudiant != null ? etudiant.hashCode() : 0);
        return result;
    }

    public boolean containsEt(Etudiant etudiant) {
        return this.etudiant.equals(etudiant);
    }

    public boolean containsMod(Module module) {
        return this.module.equals(module);
    }

    public boolean containsNota(Notation notation) {
        return this.etudiant.equals(notation);
    }

    public Module getModule() {
        return module;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Notation getNotation() {
        return note;
    }

    public void setNotation(Notation note) {
        this.note = note;
    }
}
