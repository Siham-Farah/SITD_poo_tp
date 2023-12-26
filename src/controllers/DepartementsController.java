package controllers;

import models.Departement;
import services.DB;
import services.DepServices;
import services.EnseigService;
import M.Main;




public class DepartementsController {

    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showDepartements(){
        for (Departement departement : DB.departements) {
            System.out.print("Id : " + departement.getId());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (! Main.isNull(departement.getResponsable())) {
                System.out.print(" | Chef : " + departement.getResponsable().getNom() + " " + departement.getResponsable().getPrenom());
            }
            System.out.println("");

        }
        showMenu();
    }
    public static void createDepartement(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepServices.addDept(intitule, EnseigService.getEnsById(id));

        showDepartements();
        showMenu();


    }
    public static void editDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        DepServices.updateDept(id, intitule, EnseigService.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        DepServices.deleteDeptById(id);
        showDepartements();

    }
}