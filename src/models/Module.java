package models;


public class Module {
    private int id ;
    private String intitule ;
    private Filliere filliere ;
    private Enseignant professeur ;
    public Module(){}
    public Module(String intitule,Filliere filliere ,Enseignant professeur){
        this.intitule=intitule;
        this.filliere=filliere;
        this.professeur=professeur;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }

    public Enseignant getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Enseignant professeur) {
        this.professeur = professeur;
    }
}
