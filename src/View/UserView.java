package View;

import Model.*;
import Utils.*;
import java.util.List;
import java.util.regex.Pattern;

public class UserView {
    private static final Pattern PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );
    inputs input = new inputs();
    public void displayUsers(List<User> users){
        for(User u : users){
            System.out.println(u.getId());
            System.out.println(u.getName());
            System.out.println(u.getEmail());
            System.out.println();
        }
    }

    public int displayLoginReg() {
        System.out.println("1. Login\n2. New User");
        System.out.println("Enter your Choice : ");
        return input.getInt();
    }

    public void invalid() {
        System.out.println("Invalid, Try Again!!!");
    }

    public void exit() {
        System.out.println("Exiting...");
    }

    public String getName() {
        System.out.print("Enter your Name : ");
        return input.getString();
    }

    public String getPass() {
        System.out.print("Enter your Password : ");
        return input.getString();
    }

    public void welcomeUser(String name) {
        System.out.println("Welcome "+name);
    }

    public String getEmail() {
        System.out.print("Enter your Email : ");
        String email = input.getString();
        while(!PATTERN.matcher(email).matches()){
            System.out.print("Invalid Email, try another : ");
            email = input.getString();
        }
        return email;
    }

    public void newUserAdded() {
        System.out.println("---New User Added Successfully---");
    }

    public void Login() {
        System.out.println();
        System.out.println("---Login---");
    }

    public void register() {
        System.out.println();
        System.out.println("---Register---");
    }
}
