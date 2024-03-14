package data.models;

public class Entry {
    private int id;
    private String body;
    private String title;

    public Entry(int id,String title,String body){
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
