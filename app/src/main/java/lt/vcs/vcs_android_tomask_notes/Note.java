package lt.vcs.vcs_android_tomask_notes;

import static lt.vcs.vcs_android_tomask_notes.Constants.DATABASE_TABLE_NOTES;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Entity(tableName = DATABASE_TABLE_NOTES)

public class Note {

    @PrimaryKey
    private int id;

    @ColumnInfo(name="note_name")
    private String name;

    @ColumnInfo (name = "note_content")
    private String content;

    @Ignore
    @ColumnInfo (name ="create_date")
    private LocalDateTime creationDate;

    @Ignore
    @ColumnInfo (name ="update_date")
    private LocalDateTime updateDate;

   @Ignore
    final DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Note(int id, String name, String content) {

        this.id = id;
        this.name = name;
        this.content = content;
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String toString() {
        return
                "id" + id +
                " / " + name  +
                " / " + content +
                " / " + creationDate.format(formatter) +
                " / " + updateDate.format(formatter);
    }
}
