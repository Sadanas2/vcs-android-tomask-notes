package lt.vcs.vcs_android_tomask_notes;

import static lt.vcs.vcs_android_tomask_notes.Constants.DATABASE_VERSION;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database (
        entities = {Note.class},
        version = DATABASE_VERSION,
        exportSchema = false
)

@TypeConverters({Converter.class})
public abstract class MainDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
