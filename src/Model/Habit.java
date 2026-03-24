package Model;

public class Habit {
    private int id;
    private String name;
    private String description;
    private int completedPercentage;
    private String frequency;


    public Habit(int id, String name, String description, int completedPercentage, String frequency){
        this.id = id;
        this.name = name;
        this.description = description;
        this.completedPercentage = completedPercentage;
        this.frequency = frequency;
    }

    public int getId(){
        return this.id;
    }
    public int getCompletedPercentage() {
        return completedPercentage;
    }
    public String getDescription(){
        return this.description;
    }
    public String getFrequency(){
        return this.frequency;
    }
    public String getName() {
        return name;
    }

    public String toString(){
        return ">> Habit ID : "+this.getId()+" >> Habit Name : "+this.getName()+" >> Completed Percentage : "+this.getCompletedPercentage()+"% >> Your Description : "+this.getDescription();
    }
    public String getStatus(){
        return ">> Habit Name : "+this.getName()+" >> Completed Percentage : "+this.getCompletedPercentage()+"% >> Frequency : "+this.getFrequency();
    }

    public void setCompletedPercentage(int i) {
        this.completedPercentage = i;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDesc) {
        this.description=newDesc;
    }

    public void setFrequency(String newFreq) {
        this.frequency = newFreq;
    }
}
