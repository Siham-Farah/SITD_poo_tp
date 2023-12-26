package services;
import models.Enseignant;
import models.Departement;
import java.util.ArrayList;
public class EnseigService {
    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setId(DB.getEnsId());
        enseignant.setEmail(email);
        enseignant.setGrade(grade);
        enseignant.setDepartement(dept);
        DB.enseignants.add(enseignant);

        return  enseignant ;

    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept) {
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setId(id);
                enseignant.setEmail(email);
                enseignant.setGrade(grade);
                enseignant.setDepartement(dept);
            }
            return enseignant;
        }
        return new Enseignant();
    }

    public static Enseignant getEnsById(int id) {
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id)
                return enseignant;
        }
        return new Enseignant();
    }

    public static ArrayList<Enseignant> deleteEnsById(int id) {
        DB.enseignants.remove(getEnsById(id));
        return DB.enseignants;
    }

    public static ArrayList<Enseignant> getAllEns() {
        return DB.enseignants;
    }
}