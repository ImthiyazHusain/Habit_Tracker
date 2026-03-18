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
        println("\n1. Login\n2. New User");
        print("Enter your Choice : ");
        return getInt();
    }

    public void invalid() {
        println(BG_RED+BLACK+"Invalid, Try Again!!!"+RESET);
        System.out.println(DEFAULT+" ");
    }

    public void exit() {
        println(YELLOW+"Exiting..."+RESET);
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
            print(BG_RED+BLACK+"Invalid Email, try another : "+RESET);
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
        println("1. Add a new Habit");
        println("2. Edit a Habit");
        println("3. View Habits");
        println("4. Logout");
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

    public String getHabitType() {
        print("1) Reading 2) Communication 3) Physical \nSelect the Type of Habit : ");
        int choice = getInt();
        return switch (choice) {
            case 1 -> "Reading";
            case 2 -> "Communication";
            case 3 -> "Physical";
            default -> "Unknown";
        };
    }

    public String getHabitDescription() {
        print("Add a Description : ");
        return getString();
    }

    public void displayHabits(List<Habit> habits) {
        for(Habit h : habits){
            println(h.getId()+" "+h.getName()+" "+h.getType()+" "+h.getCompletedPercentage()+" "+h.getDescription());
        }
    }
}
