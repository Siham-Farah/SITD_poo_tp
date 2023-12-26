package controllers;


import M.Main;
import models.Module;
import services.DB;
import services.EnseigService;
import services.FilliereService;
import services.ModuleService;

public class ModulesController {
    public static void showMenu(){
        System.out.println("-------------------------[ Modules ]---------------------------");


        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher des Modules");
        System.out.println("3: Pour modifier un module");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createModule();
                break;
            case 2:
                showModule();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showModule(){
        for (Module module:DB.modules) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitulé : " + module.getIntitule());
            System.out.print(" | Filliere : " + module.getFilliere());
            System.out.print(" | responsable : " + module.getProfesseur() );
            System.out.println("");
        }
    }
    public static void createModule(){
        String Intitule = Main.getStringInput("Entrez l'intitulé :");
        FilieresController.showFilliere();
        int id_fil = Main.getIntInput("Sélecionnez une filliére  par id :");
        EnseignantsController.showEnseignants();
        int id_ens = Main.getIntInput("Sélecionnez un enseignant par id :");
        ModuleService.addModule(Intitule,EnseigService.getEnsById(id_ens),FilliereService.getFiliereById(id_fil));
        showModule();
        showMenu();


    }
    public static void editModule(){
        showModule();
        int id = Main.getIntInput("Sélecionnez un module  par id :");
        String Intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id_ens = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementsController.showDepartements();
        int id_fil = Main.getIntInput("Sélecionnez une filliére  par id :");
        ModuleService.updateModule(id,Intitule, EnseigService.getEnsById(id_ens),FilliereService.getFiliereById(id_fil));
        showModule();
        showMenu();
    }
    public static void destroyModule(){
        showModule();
        int id = Main.getIntInput("Sélecionnez un module par id :");
        ModuleService.deleteModuleById(id);
        showModule();

    }
}