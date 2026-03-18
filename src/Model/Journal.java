package Model;

import java.time.LocalDate;

public class Journal {

    private int id;
    private String content;
    private LocalDate date;

    public Journal(int id, String content) {
        this.id = id;
        this.content = content;
        this.date = LocalDate.now();
    }

    public int getId() { return id; }
    public String getContent() { return content; }
    public LocalDate getDate() { return date; }
}