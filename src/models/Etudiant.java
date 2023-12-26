package models;

import java.util.ArrayList;

public class Etudiant {
    private int id;
    private String nom  ;
    private String prenom ;
    private String email  ;
    private int  codeApogée ;
    private Filliere filliere ;
    ArrayList<Note> notes=new ArrayList<Note>();
    public Etudiant(){}
    public Etudiant(String nom,String prenom,String email,int  codeApogée,Filliere filliere){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.codeApogée=codeApogée;
        this.filliere=filliere;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodeApogée() {
        return codeApogée;
    }

    public void setCodeApogée(int codeApogée) {
        this.codeApogée = codeApogée;
    }

    public Filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
}
