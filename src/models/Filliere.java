package models;


import java.util.ArrayList;
import java.util.List;

public class Filliere {
    private int id ;
    private String intitule;
    private Departement departement;
    private Enseignant responsable ;
    ArrayList<Module> modules =new ArrayList<Module>();
    public Filliere(){}
    public Filliere(String intitule,Departement departement,Enseignant responsable){
        this.intitule=intitule;
        this.departement=departement;
        this.responsable=responsable;
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Enseignant getResponsable() {
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

}