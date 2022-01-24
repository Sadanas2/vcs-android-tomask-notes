package lt.vcs.vcs_android_tomask_notes.repository;

import static lt.vcs.vcs_android_tomask_notes.Constants.DATABASE_TABLE_NOTES;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lt.vcs.vcs_android_tomask_notes.module.Note;

@Dao
public interface NoteDao {
        @Query("SELECT * FROM "+DATABASE_TABLE_NOTES)
        List<Note> getAll();

        @Query("SELECT * FROM " + DATABASE_TABLE_NOTES + " WHERE id=:id")
        Note getItem(int id);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertNotes(List<Note> notes);


}
