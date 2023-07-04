package businessLayer;

import configureLayer.Note;
import dataLayer.NotesRepository;

import java.util.List;
import java.util.Optional;

public class Service {

    NotesRepository notesRepository;

    public void setNotesRepository(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public void insertNote(Note note) {
        notesRepository.create(note);
    }

    public Optional<List<Note>> getAllNotes() {
        return notesRepository.getAll();
    }


    public Optional<Note> getIdNotes(Long id) {
        return notesRepository.getIdNotes(id);
    }

    public void delete(Long id) {
        notesRepository.delete(id);
    }

}
