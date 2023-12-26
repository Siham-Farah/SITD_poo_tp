package models;

public class Note {
    private int id;
    private double valeur;
    private Etudiant etudiant;
    private Module module;
    public Note(Module module, double valeur ) {
        this.valeur = valeur;
        this.module = module;
    }
    public Note() {}




    public double getValeur() {return valeur;}

    public Etudiant getEtudiant() {return etudiant;}

    public int getId() {return id;}

    public Module getModule() {return module;}

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}

