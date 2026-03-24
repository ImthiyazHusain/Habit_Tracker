package Controller;
import Model.*;
import View.UserView;

import java.util.*;

import static Utils.output.println;

public class UserController {
    private static final List<Community> communities = new ArrayList<>();
    private final UserView userView = new UserView();

    private static final Map<String, User> userMap = new HashMap<>();
    private static final List<User> users = new ArrayList<>();

    public void createUser(String name, String email, String password) {
        int newId = users.isEmpty() ? 1 : users.getLast().getId() + 1;

        User newUser = new User(newId, name, email, password);
        users.add(newUser);
        userMap.put(email, newUser);
    }

    public void displayUsers() {
        userView.displayUsers(users);
    }

    public boolean verifyUser(String email, String pass) {
        if (userMap.containsKey(email)) {
            User u = userMap.get(email);
            return pass.equals(u.getPassword());
        }
        return false;
    }

    public User getUser(String email) {
        return userMap.get(email);
    }
    User user;
    public void login(User u) {
        user = u;
        while (true) {
            int choice = userView.displayMenu();
            switch (choice) {
                case 1: {
                    habitOperations();
                    break;
                }
                case 2: {
                    communityOperations();
                    break;
                }
                case 3: {
                    postOperations();
                    break;
                }
                case 4: {
                    journalOperatins();
                    break;
                }
                case 5: {
                    rewardsEarned();
                    break;
                }
                case 6: {
                    userView.exit();
                    return;
                }
                default:
                    userView.invalid();
            }
        }
    }

    private void journalOperatins() {
        while (true) {

            int op = userView.getJournalOption();

            switch (op) {
                case 1 -> writeJournal();
                case 2 -> editJournal();
                case 3 -> deleteJournal();
                case 4 -> { return; }
            }
        }
    }
    private void writeJournal() {
        println("Write your journal:");
        String content = userView.getContent();

        Journal j = new Journal(user.getJournals().size() + 1, content);
        user.getJournals().add(j);

        println("📝 Saved!");
    }
    private void editJournal() {
        for (Journal j : user.getJournals()) {
            println(j.getId() + " " + j.getContent());
        }

        int id = userView.getId();

        for (Journal j : user.getJournals()) {
            if (j.getId() == id) {
                j.setContent(userView.getContent());
                println("✏ Updated!");
                return;
            }
        }
    }
    private void deleteJournal() {
        Iterator<Journal> it = user.getJournals().iterator();

        while (it.hasNext()) {
            Journal j = it.next();
            println(j.getId() + " " + j.getContent());
        }

        int id = userView.getId();

        it = user.getJournals().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                println("🗑 Deleted!");
                return;
            }
        }
    }
    private void postOperations() {
        while (true) {
            int op = userView.postOperation();

            switch (op) {
                case 1 -> createPost();
                case 2 -> editPost();
                case 3 -> deletePost();
                case 4 -> sharePost();
                case 5 -> { return; }
            }
        }
    }
    private void createPost() {

        String content = userView.createPost();


        Post p = new Post(user.getPosts().size() + 1, content);
        user.getPosts().add(p);

        println("✅ Post created!");
    }
    private void editPost() {
        for (Post p : user.getPosts()) {
            println(p.getId() + " " + p.getContent());
        }

        int id = userView.getId();

        for (Post p : user.getPosts()) {
            if (p.getId() == id) {
                println("New content:");
                p.setContent(userView.getContent());
                println("✏ Updated!");
                return;
            }
        }
    }
    private void deletePost() {
        Iterator<Post> it = user.getPosts().iterator();

        while (it.hasNext()) {
            Post p = it.next();
            println(p.getId() + " " + p.getContent());
        }

        int id = userView.getId();

        it = user.getPosts().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                println("🗑 Deleted!");
                return;
            }
        }
    }
    private void sharePost() {
        if (user.getCommunities().isEmpty()) {
            println("Join community first!");
            return;
        }

        for (Post p : user.getPosts()) {
            println(p.getId() + " " + p.getContent());
        }

        println("Select post ID:");
        int pid = userView.getId();

        for (Community c : user.getCommunities()) {
            println(c.getId() + " " + c.getName());
        }

        println("Select community ID:");
        int cid = userView.getId();

        Post selected = null;
        for (Post p : user.getPosts()) {
            if (p.getId() == pid) selected = p;
        }

        for (Community c : user.getCommunities()) {
            if (c.getId() == cid && selected != null) {
                c.getPosts().add(selected);
                println("🚀 Shared!");
                return;
            }
        }
    }

    private void communityOperations() {
        while (true) {
            int op = userView.showCommunityOptions();
            switch (op) {
                case 1 -> createCommunity();
                case 2 -> joinCommunity();
                case 3 -> viewMyCommunities();
                case 4 -> leaveCommunity();
                case 5 -> { return; }
            }
        }
    }
    private void createCommunity() {
        String name = userView.createCommunity();

        int id = communities.size() + 1;
        Community c = new Community(id, name);

        c.addMember(user);
        user.joinCommunity(c);

        communities.add(c);

        println("✅ Community created!");
    }

    private void joinCommunity() {
        if (communities.isEmpty()) {
            println("No communities available!");
            return;
        }

        for (Community c : communities) {
            println(c.getId() + " " + c.getName());
        }

        println("Enter community ID to join:");
        int id = userView.getCommunityId();

        for (Community c : communities) {
            if (c.getId() == id) {
                c.addMember(user);
                user.joinCommunity(c);
                println("✅ Joined successfully!");
                return;
            }
        }

        println("❌ Community not found!");
    }

    private void viewMyCommunities() {
        List<Community> my = user.getCommunities();

        if (my.isEmpty()) {
            println("You haven't joined any communities!");
            return;
        }

        for (Community c : my) {
            println(c.getId() + " " + c.getName());
        }

        println("1.Enter Community\n2.Exit");
        int ch = userView.getCommunityId();

        if (ch == 1) {
            println("Enter ID:");
            int id = userView.getCommunityId();

            for (Community c : my) {
                if (c.getId() == id) {
                    insideCommunity(c);
                    return;
                }
            }
        }
    }

    private void insideCommunity(Community c) {
        while (true) {
            int op = userView.getIntoCom(c);

            switch (op) {
                case 1 -> {
                    String content = userView.getContent();

                    Post p = new Post(c.getPosts().size() + 1, content);
                    c.getPosts().add(p);

                    println("✅ Posted!");
                }
                case 2 -> {
                    for (Post p : c.getPosts()) {
                        println(p.getId() + ": " + p.getContent());
                    }
                }
                case 3 -> { return; }
            }
        }
    }

    private void leaveCommunity() {
        List<Community> my = user.getCommunities();

        if (my.isEmpty()) {
            println("No communities to leave!");
            return;
        }

        for (Community c : my) {
            println(c.getId() + " " + c.getName());
        }

        println("Enter ID to leave:");
        int id = userView.getCommunityId();

        Iterator<Community> it = my.iterator();

        while (it.hasNext()) {
            Community c = it.next();
            if (c.getId() == id) {
                it.remove();
                user.leaveCommunity(c);
                c.getMembers().remove(user);
                println("👋 Left community");
                return;
            }
        }
    }

    private void habitOperations() {
        while(true) {
            int op = userView.displayHabitMenu();
            switch (op) {
                case 1: {
                    addNewHabit();
                    break;
                }
                case 2: {
                    editHabit();
                    break;
                }
                case 3: {
                    viewHabits();
                    break;
                }
                case 4: {
                    setRemainder();
                    break;
                }
                case 5: {
                    removeHabit();
                    break;
                }
                case 6: {
                    status();
                    break;
                }
                case 7: {
                    markAsDone();
                    break;
                }
                case 8:{
                    println("AI coming soon!!!");
                    break;
                }
                case 9: {
                    userView.exit();
                    return;
                }
            }
        }
    }

    private void markAsDone() {
        int id = userView.getHabitId(user.getHabits());

        if(id == 0){
            println("❌ No Habit found!");
            return;
        }

        for (Habit h : user.getHabits()) {
            if (h.getId() == id) {

                if (h.getCompletedPercentage() == 100) {
                    println("Already completed!");
                    return;
                }

                h.setCompletedPercentage(100);
                println("✅ Habit marked as DONE!");

                Reward r = new Reward(
                        user.getRewards().size() + 1,
                        "Completed: " + h.getName(),
                        10
                );

                user.addReward(r);

                println("🎁 Reward Earned: +10 points!");

                return;
            }
        }

        println("❌ Habit not found!");
    }

    private void rewardsEarned() {

        List<Reward> rewards = user.getRewards();


        if (rewards.isEmpty()) {
            println("No rewards yet! Start completing habits 💪");
            return;
        }

        int total = 0;

        println("\n🎁 Your Rewards:");
        for (Reward r : rewards) {
            println(r.getId() + ". " + r.getTitle() + " → " + r.getPoints() + " pts");
            total += r.getPoints();
        }

        println("------------------------");
        println("🔥 Total Points: " + total);
    }

    private void status() {
        List<Habit> habits = user.getHabits();
        userView.displayStatus(habits);
    }

    private void removeHabit() {
        int id = userView.getHabitId(user.getHabits());
        if(id == 0){
            println("No Habit found!!!");
            return;
        }
        Iterator<Habit> it = user.getHabits().iterator();

        while (it.hasNext()) {
            Habit h = it.next();
            if (h.getId() == id) {
                it.remove();
                println("🗑 Habit removed successfully!");
                return;
            }
        }
        println("❌ Habit not found!");
    }

    private void setRemainder() {
        int id = userView.getHabitId(user.getHabits());
        if(id == 0){
            println("No Habit found!!!");
            return;
        }
        for (Habit h : user.getHabits()) {
            if (h.getId() == id) {

                int seconds = userView.getReminderTime();

                ReminderThread rt = new ReminderThread(h.getName(), seconds);
                rt.start();

                println("⏰ Reminder set for " + seconds + " seconds!");
                return;
            }
        }
        println("❌ Habit not found!");
    }

    private void addNewHabit() {
        int newHabitId = user.getHabits().size() + 1;
        String habitName = userView.getHabit();
        String habitDescription = userView.getHabitDescription();
        int completedPercentage = 0;
        String frequency = userView.getFrequency();

        Habit habit = new Habit(newHabitId, habitName, habitDescription,completedPercentage, frequency);

        user.addHabit(habit);
    }

    private void viewHabits() {
        List<Habit> habits = user.getHabits();
        userView.displayHabits(habits);
    }

    private void editHabit() {
        int id = userView.getHabitId(user.getHabits());
        if(id == 0){
            println("No Habit found!!!");
            return;
        }
        for (Habit h : user.getHabits()) {
            if (h.getId() == id) {

                String newName = userView.getHabit();
                String newDesc = userView.getHabitDescription();
                String newFreq = userView.getFrequency();

                h.setName(newName);
                h.setDescription(newDesc);
                h.setFrequency(newFreq);

                println("✏ Habit updated successfully!");
                return;
            }
        }
        println("❌ Habit not found!");
    }
}