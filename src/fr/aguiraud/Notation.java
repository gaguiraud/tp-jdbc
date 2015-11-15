package fr.aguiraud;

/**
 * Created by guillaumeaguiraud on 30/10/15.
 */
public class Notation {
    private float moyCC;
    private float moyTest;
    private Etudiant etudiant;
    private Module module;

    public Notation(float moyCC, float moyTest) {
        this.moyCC = moyCC;
        this.moyTest = moyTest;
    }

    public Notation() {}

    public float getMoyCC() {
        return moyCC;
    }

    @Override
    public String toString() {
        return "Notation{" +
                "moyCC=" + moyCC +
                ", moyTest=" + moyTest +
                '}';
    }

    public void setMoyCC(float moyCC) {
        this.moyCC = moyCC;
    }

    public float getMoyTest() {
        return moyTest;
    }

    public void setMoyTest(float moyTest) {
        this.moyTest = moyTest;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
