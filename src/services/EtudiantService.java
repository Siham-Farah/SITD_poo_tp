package services;

import models.Enseignant;
import models.Filliere;
import models.Etudiant;
import java.util.ArrayList;

public class EtudiantService {
    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, Filliere filliere){
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(nom);
        etudiant.setId(DB.getEtdId());
        etudiant.setEmail(email);
        etudiant.setCodeApogée(apogee);
        etudiant.setFilliere(filliere);
        DB.etudiants.add(etudiant);

        return  etudiant ;

    }

    public static Etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filliere filliere){
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id) {
                etudiant.setNom(nom);
                etudiant.setPrenom(nom);
                etudiant.setId(DB.getEtdId());
                etudiant.setEmail(email);
                etudiant.setCodeApogée(apogee);
                etudiant.setFilliere(filliere);
            }
            return etudiant;
        }
        return new Etudiant();
    }
    public static Etudiant getEtdById(int id){
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id)
                return etudiant;
        }
        return  new Etudiant();
    }
    public static ArrayList<Etudiant> deleteEtdById(int id){
        DB.etudiants.remove(getEtdById(id));
        return  DB.etudiants;
    }



    public static ArrayList<Etudiant> getAllEtd(){

        return  DB.etudiants;
    }
}