package fr.aguiraud;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by guillaumeaguiraud on 30/10/15.
 */
public class AssociationNotation {
    private Set<Lien> liens = new HashSet<>();
    private static AssociationNotation instance;

    public void creerLien(Module mod, Etudiant etu, Notation note){
        Lien lien = new Lien(mod, etu);
        lien.setNotation(note);
        liens.add(lien);
    }

    public void supprimerLien(Module module, Etudiant etudiant) {
        liens.remove(new Lien(module, etudiant));
    }

    public void supprimerLien(Lien lien) {
        liens.remove(lien);
    }

    public Lien getLien(Module module, Notation note) {
        for (Lien lien : liens) {
            if (lien.containsMod(module) && lien.containsNota(note)) return lien;
        }
        return null;
    }

    public Set<Lien> getLiens(Etudiant etudiant) {
        Set<Lien> allEtu = new HashSet<>();
        for (Lien lien : liens) {
            if (lien.containsEt(etudiant))  allEtu.add(lien);
        }
        return allEtu;
    }

    public Set<Lien> getLiens() {
        return liens;
    }

    public Set<Lien> getLiens(Module module) {
        Set<Lien> allMod = new HashSet<>();
        for (Lien lien : liens) {
            if (lien.containsMod(module)) allMod.add(lien);
        }
        return allMod;
    }

    public Set<Module> getModules(Etudiant etudiant) {
        Set<Module> allEtu = new HashSet<>();
        for (Lien lien : liens) {
            if (lien.containsEt(etudiant)) allEtu.add(lien.getModule());
        }
        return allEtu;
    }

    public Set<Etudiant> getEtudiants(Module module) {
        Set<Etudiant> allMod = new HashSet<>();
        for (Lien lien : liens) {
            if (lien.containsMod(module)) allMod.add(lien.getEtudiant());
        }
        return allMod;
    }

    public static AssociationNotation getInstance() {
        if (instance == null) {
            instance = new AssociationNotation();
        }
        return instance;
    }
}
