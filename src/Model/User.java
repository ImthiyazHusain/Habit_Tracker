package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private List<Habit> habit = new ArrayList<>();
    private List<Reward> rewards = new ArrayList<>();

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

    private List<Post> posts = new ArrayList<>();
    private List<Journal> journals = new ArrayList<>();

    public List<Post> getPosts() { return posts; }
    public List<Journal> getJournals() { return journals; }

    private List<Community> communities = new ArrayList<>();

    public List<Community> getCommunities() {
        return communities;
    }

    public void joinCommunity(Community c) {
        if (!communities.contains(c)) {
            communities.add(c);
        }
    }

    public void leaveCommunity(Community c) {
        communities.remove(c);
    }

    public void addReward(Reward r) {
        rewards.add(r);
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
