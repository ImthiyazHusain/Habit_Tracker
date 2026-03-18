package Model;

public class Reward {

    private int id;
    private String title;
    private int requiredPoints;

    public Reward(int id, String title, int requiredPoints) {
        this.id = id;
        this.title = title;
        this.requiredPoints = requiredPoints;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getRequiredPoints() { return requiredPoints; }
}
