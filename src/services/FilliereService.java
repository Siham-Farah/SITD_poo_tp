package services;
import models.Departement;
import models.Enseignant;
import models.Etudiant;
import models.Filliere;
import java.util.ArrayList;

import java.util.ArrayList;

public class FilliereService {
    public static Filliere addFiliere(String intitule, Enseignant responsable, Departement dept) {
        Filliere filliere = new Filliere();
        filliere.setIntitule(intitule);
        filliere.setResponsable(responsable);
        filliere.setId(DB.getFilId());
        filliere.setDepartement(dept);
        DB.filieres.add(filliere);

        return filliere;
    }

    public static Filliere updateFiliere(int id, String intitule, Enseignant responsable, Departement dept) {
        for (Filliere filliere : DB.filieres) {
            if (filliere.getId() == id) {
                filliere.setIntitule(intitule);
                filliere.setResponsable(responsable);
                filliere.setId(id);
                filliere.setDepartement(dept);
            }
            return filliere;
        }
        return new Filliere();
    }
    public static Filliere getFiliereById ( int id){
        for (Filliere filliere : DB.filieres) {
            if (filliere.getId() == id)
                return filliere;
        }
        return new Filliere();
    }
    public static ArrayList<Filliere> deleteFiliereById ( int id){
        DB.filieres.remove(getFiliereById(id));
        return DB.filieres;
    }


    public static ArrayList<Filliere> getAllFiliere () {
        return DB.filieres;
    }
}