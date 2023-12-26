package controllers;


import M.Main;
import models.Enseignant;
import services.DB;
import services.DepServices;
import services.EnseigService;

public class EnseignantsController {
    public static void showMenu(){
        System.out.println("-------------------------[ Enseignants ]---------------------------");


        System.out.println("1: Pour ajouter un Enseignant");
        System.out.println("2: Pour afficher les Enseignants");
        System.out.println("3: Pour modifier un Enseignant");
        System.out.println("4: Pour supprimer un Enseignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );
            System.out.print(" | Grade : " + enseignant.getGrade() );
            System.out.print(" | Departement : " + enseignant.getDepartement() );
            System.out.println("");
        }
    }
    public static void createEnseignant(){
        String nom = Main.getStringInput("Entrez le nom  :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l email :");
        String grade = Main.getStringInput("Entrez le grade :");

        EnseignantsController.showEnseignants();

        int id = Main.getIntInput("Sélecionnez id de enseignat  :");
        EnseigService.addEns(nom,prenom,email,grade,DepServices.getDeptById(id));
        showEnseignants();
        showMenu();


    }


    public static void editEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez nom :");
        String prenom = Main.getStringInput("Entrez prenom :");
        String email = Main.getStringInput("Entrez email :");
        String grade = Main.getStringInput("Entrez grade :");
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseigService.updateEns(id,nom,prenom,email,grade,DepServices.getDeptById(id));
        EnseignantsController.showEnseignants();
        showMenu();
    }
    public static void destroyEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseigService.deleteEnsById(id);
        showEnseignants();

    }
}
