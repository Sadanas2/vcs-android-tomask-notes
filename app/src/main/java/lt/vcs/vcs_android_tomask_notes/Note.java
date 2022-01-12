package lt.vcs.vcs_android_tomask_notes;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {

    private int id;
    private String name;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
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
