package com.notes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name="notes")
public class Note {
    @Id
    private int id;
    private String title;
    private String content;
    private Date timestamp;

    public Note(String title, String content, Date timestamp) {
        super();
        this.id = new Random().nextInt(1000000);
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }
    public Note()
    {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
