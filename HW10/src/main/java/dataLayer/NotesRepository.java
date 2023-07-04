package dataLayer;

import configureLayer.Note;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class NotesRepository {

    public static HashMap<Long, Note> db = new HashMap<>();

    public Long id = 1l;


    public void create(Note note) {
        db.put(id, note);
        id++;
    }

    public Optional<List<Note>> getAll() {
        return Optional.of(db.values().stream().toList());
    }

    public Optional<Note> getIdNotes(Long id) {
        System.out.println(db.values());
        System.out.println(db.get(id));
        return Optional.of(db.get(id));
    }

    public void delete(Long id) {
        if(db.containsKey(id)) {
            db.remove(id);
        }
    }
}
