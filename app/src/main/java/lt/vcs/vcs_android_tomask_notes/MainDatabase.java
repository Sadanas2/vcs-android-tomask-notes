package lt.vcs.vcs_android_tomask_notes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (
        entities = {Note.class},
        version = 1,
        exportSchema = false
)

public abstract class MainDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();





}
