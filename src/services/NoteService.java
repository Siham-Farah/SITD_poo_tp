// services/NoteService.java
package services;

import models.Module;
import models.Note;

import java.util.ArrayList;

public class NoteService {
    public static Note addNote(Module module, double value) {
        Note note = new Note(module, value);
        note.setId(DB.getNoteId());
        DB.notes.add(note);
        return note;
    }

    public static Note updateNote(int id, Module module, double value) {
        for (Note note : DB.notes) {
            if (note.getId() == id) {
                note.setModule(module);
                note.setValeur(value);
                return note;
            }
        }
        return new Note();
    }

    public static Note getNoteById(int id) {
        for (Note note : DB.notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return new Note();
    }

    public static ArrayList<Note> deleteNoteById(int id) {
        DB.notes.remove(getNoteById(id));
        return DB.notes;
    }

    public static ArrayList<Note> getAllNotes() {
        return DB.notes;
    }
}
