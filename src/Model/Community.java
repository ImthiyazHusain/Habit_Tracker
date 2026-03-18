package Model;

import java.util.ArrayList;
import java.util.List;

public class Community {

    private int id;
    private String name;
    private List<User> members = new ArrayList<>();

    public Community(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addMember(User user) {
        members.add(user);
    }

    public List<User> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }
}