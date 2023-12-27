// controllers/NotesController.java
package controllers;

import M.Main;
import models.Etudiant;
import models.Module;
import models.Note;
import services.DB;
import services.EtudiantService;
import services.ModuleService;
import services.NoteService;

import static controllers.EtudiantsController.showEtudiant;

public class NotesController {
    public static void showMenu() {
        System.out.println("-------------------------[ Notes ]---------------------------");
        System.out.println("1: Pour ajouter une note");
        System.out.println("2: Pour afficher les notes");
        System.out.println("3: Pour modifier une note");
        System.out.println("4: Pour supprimer une note");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createNote();
                break;
            case 2:
                showNotes();
                break;
            case 3:
                editNote();
                break;
            case 4:
                destroyNote();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showNotes() {
        for (Note note : DB.notes) {
            System.out.print("Id : " + note.getId());
            System.out.print(" | Module : " + note.getModule().getIntitule());
            System.out.print(" | Etudiant : " + note.getEtudiant().getNom());
            System.out.print(" | Valeur : " + note.getValeur());
            System.out.println("");
        }
    }

    public static void createNote() {
        showModules();
        int moduleId = Main.getIntInput("Sélectionnez un module par id :");
        showEtudiant();
        int EtudeId = Main.getIntInput("Sélectionnez un etudiant par id :");
        int value = Main.getIntInput("Entrez la valeur de la note :");
        Module module = ModuleService.getModuleById(moduleId);
        Etudiant etudiant= EtudiantService.getEtdById(EtudeId);
        showNotes();
        showMenu();
    }

    public static void editNote() {
        showNotes();
        int id = Main.getIntInput("Sélectionnez une note par id :");
        showModules();
        int moduleId = Main.getIntInput("Sélectionnez un module par id :");
        int value = Main.getIntInput("Entrez la nouvelle valeur de la note :");
        Module module = ModuleService.getModuleById(moduleId);

        NoteService.updateNote(id, module, value);
        showNotes();
        showMenu();
    }

    public static void destroyNote() {
        showNotes();
        int id = Main.getIntInput("Sélectionnez une note par id :");
        NoteService.deleteNoteById(id);
        showNotes();
    }

    private static void showModules() {
        System.out.println("Modules disponibles :");
        ModuleService.getAllModule().forEach(module -> {
            System.out.println("Id : " + module.getId() + " | Intitulé : " + module.getIntitule());
        });
    }
}
