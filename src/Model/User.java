package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private List<Habit> habit = new ArrayList<>();

    public User(int id,String name,String email,String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() { return id; }
    public String getName(){ return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public List<Habit> getHabits(){ return habit; };

    public void addHabit(Habit habit) {
        this.habit.add(habit);
    }

    public List<Habit> getHabit() {
        return this.habit;
    }
}
