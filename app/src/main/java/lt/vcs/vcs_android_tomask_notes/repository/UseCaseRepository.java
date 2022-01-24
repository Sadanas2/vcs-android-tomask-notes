package lt.vcs.vcs_android_tomask_notes.repository;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lt.vcs.vcs_android_tomask_notes.module.Note;

public class UseCaseRepository {


    NoteDao noteDao;

    public UseCaseRepository(Context context) {
        MainDatabase mainDatabase = MainDatabase.getInstance(context);
        noteDao = mainDatabase.noteDao();
    }

    public List<Note> getAll() {
    return noteDao.getAll();
}

@NonNull
        public List<Note>generateNoteList(int count) {
        List<Note> notes = new ArrayList<>();

        Random random = new Random();
        Note note;

        int i = 1;
        while (i <= count) {
            note = new Note(i, "Name" + i, "Content" + i + " - " + random.nextInt(100000));
            notes.add(note);
            i++;

        }
        return notes;
    }
}
