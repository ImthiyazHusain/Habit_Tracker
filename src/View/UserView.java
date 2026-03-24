package View;

import Model.*;

import static Utils.inputs.*;
import static Utils.output.*;
import static Utils.Colors.*;

import java.util.List;
import java.util.regex.Pattern;

public class UserView {
    private static final Pattern PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );
    public void displayUsers(List<User> users){
        for(User u : users){
            println(u.getId());
            println(u.getName());
            println(u.getEmail());
            println("");
        }
    }

    public int displayLoginReg() {
        println("\n1. Login\n2. New User\n3. Exit");
        print("Enter your Choice : ");
        return getInt();
    }

    public void invalid() {
        println(BG_RED+BLACK+"Invalid, Try Again!!!"+RESET);
        System.out.println(DEFAULT+" ");
    }

    public void exit() {
        println(YELLOW+"Exiting...\n"+RESET);
        print(DEFAULT);
    }

    public String getName() {
        print("Enter your Name : ");
        return getString();
    }

    public String getPass() {
        print("Enter your Password : ");
        return getString();
    }

    public void welcomeUser(String name) {
        println(GREEN+"Welcome "+name+ DEFAULT);
    }

    public String getEmail() {
        print("Enter your Email : ");
        String email = getString();
        while(!PATTERN.matcher(email).matches()){
            print(BG_RED+BLACK+"Invalid Email, try another"+RESET+" : ");
            print(RESET);
            email = getString();
        }
        return email;
    }

    public void newUserAdded() {
        println(GREEN+"---New User Added Successfully---"+DEFAULT);
    }

    public void login() {
        println("");
        println(BG_BRIGHT_BLUE+BLACK+"---Login---"+RESET);
        print(DEFAULT);
    }

    public void register() {
        println("");
        println(BG_BRIGHT_BLUE+BLACK+"---Register---"+RESET);
        print(DEFAULT);
    }

    public int displayMenu() {
        println(BG_BRIGHT_BLUE+BLACK+"---Options---"+RESET);
        println("1.Habit");
        println("2.Community");
        println("3.Post");
        println("4.Journal");
        println("5.Rewards Earned");
        println("6. Logout");
        return getInt();
    }

    public String getHabit() {
        print("Enter your New Habit : ");
        return getString();
    }

    public int getGoalDays() {
        print("Enter your goal(Days) : ");
        return getInt();
    }

    public String getHabitDescription() {
        print("Add a Description : ");
        return getString();
    }

    public void displayHabits(List<Habit> habits) {
        println("\n"+BG_BLUE+BLACK+"Your Habits!!!"+RESET);
        for(Habit h : habits){
            println(h.getStatus());
        }
    }

    public int displayHabitMenu() {
        println("1. Add a new Habit");
        println("2. Edit a Habit");
        println("3. View Habits");
        println("4. Set Remainders");
        println("5. Remove a Habit");
        println("6. Status of all Habits");
        println("7. Mark as Done");
        println("8. AI help");
        println("9. Exit");
        int op = getInt();
        if(op<=0 || op>9){
            println("Invalid Input! Please Enter a valid option");
            return displayHabitMenu();
        }
        return op;
    }

    public void displayStatus(List<Habit> habits) {
        println("\n"+BG_BLUE+BLACK+"Your daily Habits Status!!!"+RESET);
        for(Habit h : habits){
            println(h.getStatus());
        }
    }

    public String getFrequency() {
        println("Options : ");
        println("1. Daily");
        println("2. weekly");
        println("3. Monthly");
        int op = getInt();
        return switch (op) {
            case 1 -> "Daily";
            case 2 -> "weekly";
            case 3 -> "Monthly";
            default -> "daily";
        };
    }

    public int getHabitId(List<Habit> habits) {
        println("\n"+BG_BLUE+BLACK+"Your Habits!!! "+RESET);
        print("Select By ID : ");
        if(habits.isEmpty()){
            return 0;
        }
        for(Habit h : habits){
            println(h.getId()+" "+h.getName());
        }
        return getInt();
    }

    public int getReminderTime() {
        println("Enter time in seconds : ");
        return getInt();
    }

    public int showCommunityOptions() {
        println("\n1.Create Community\n2.Join Community\n3.View My Communities\n4.Leave Community\n5.Back");
        return getInt();
    }

    public String createCommunity() {
        println("Enter community Name : ");
        return getString();
    }

    public int getCommunityId() {
        println("Enter ID :");
        return getInt();
    }

    public int getIntoCom(Community c) {
        println("\n--- " + c.getName() + " ---");
        println("1.Add Post\n2.View Posts\n3.Exit");
        return getInt();
    }

    public String getContent() {
        println("Enter content:");
        return getString();
    }

    public int postOperation() {
        println("\n1.Create\n2.Edit\n3.Delete\n4.Share to Community\n5.Back");
        return getInt();
    }

    public String createPost() {
        println("Enter content:");
        return getString();
    }

    public int getId() {
        println("Enter ID : ");
        return getInt();
    }

    public int getJournalOption() {
        println("\n1.Write\n2.Edit\n3.Delete\n4.Back");
        return getInt();
    }
}
