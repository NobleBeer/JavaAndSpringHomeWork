package configureLayer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllNotes {
    public List<Note> notes;

    public AllNotes(List notes) {
        this.notes = notes;
    }
}