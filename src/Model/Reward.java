package Model;

public class Reward {
    private int id;
    private String title;
    private int points;

    public Reward(int id, String title, int points) {
        this.id = id;
        this.title = title;
        this.points = points;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getPoints() { return points; }
}