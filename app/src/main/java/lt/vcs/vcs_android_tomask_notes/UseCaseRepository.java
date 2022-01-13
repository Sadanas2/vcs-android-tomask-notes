package lt.vcs.vcs_android_tomask_notes;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UseCaseRepository {

@NonNull
        public List<Note>generateNoteList(int count) {
        List<Note> notes = new ArrayList<>();

        Random random = new Random();
        Note note;

        int i = 1;
        while (i <= 10) {
            note = new Note(i, "Name" + i, "Content" + i + " - " + random.nextInt(100000));
            notes.add(note);
            i++;

        }
        return notes;
    }
}
