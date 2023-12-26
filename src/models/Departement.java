package models;

import java.util.ArrayList;
import java.util.List;

public class Departement {
    private int id ;
    private String intitule ;
    private Enseignant responsable ;
    ArrayList<Filliere> filliere =new ArrayList<Filliere>();
    public Departement(){}
    public Departement(String intitule ,Enseignant responsable){
        this.intitule=intitule;
        this.responsable=responsable ;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getIntitule(){
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    public Enseignant getResponsable(){
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public ArrayList<Filliere> getFilliere() {
        return filliere;
    }

    public void setFilliere(ArrayList<Filliere> filliere) {
        this.filliere = filliere;
    }
}