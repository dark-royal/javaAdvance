package data.models;

import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String body;
    private String title;
    private LocalDateTime dateCreated = LocalDateTime.now();

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Entry(int id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }
}
