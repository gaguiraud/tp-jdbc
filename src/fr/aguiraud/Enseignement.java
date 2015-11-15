package fr.aguiraud;

public class Enseignement {
    private Etudiant Etudiant;
    private Module Module;
    private Prof Prof;

    @Override
    public String toString() {
        return "Enseignement{" +
                "Etudiant=" + Etudiant +
                ", Module=" + Module +
                ", Prof=" + Prof +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enseignement that = (Enseignement) o;

        if (Etudiant != null ? !Etudiant.equals(that.Etudiant) : that.Etudiant != null) return false;
        if (Module != null ? !Module.equals(that.Module) : that.Module != null) return false;
        return !(Prof != null ? !Prof.equals(that.Prof) : that.Prof != null);

    }

    @Override
    public int hashCode() {
        int result = Etudiant != null ? Etudiant.hashCode() : 0;
        result = 31 * result + (Module != null ? Module.hashCode() : 0);
        result = 31 * result + (Prof != null ? Prof.hashCode() : 0);
        return result;
    }

    public Module getModule() {
        return Module;
    }

    public void setModule(Module module) {
        Module = module;
    }

    public Prof getProf() {
        return Prof;
    }

    public void setProf(Prof prof) {
        Prof = prof;
    }

    public Etudiant getEtudiant() {
        return Etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        Etudiant = etudiant;
    }
}
