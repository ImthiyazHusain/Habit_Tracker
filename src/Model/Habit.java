package Model;

public class Habit {
    private int id;
    private String type;
    private String name;
    private String description;
    private int completedPercentage;
    private int goalDays;

    public Habit(int id, String type, String name, String description, int completedPercentage, int goalDays){
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.completedPercentage = completedPercentage;
        this.goalDays = goalDays;
    }

    public int getId(){
        return this.id;
    }
    public String getType(){
        return this.type;
    }
    public int getCompletedPercentage() {
        return completedPercentage;
    }
    public String getDescription(){
        return this.description;
    }
    public int getGoalDays(){
        return this.goalDays;
    }
    public String getName() {
        return name;
    }
}
