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
        System.out.print("Enter your Choice : ");
        return input.getInt();
    }

    public void invalid() {
        System.out.println(Colors.RED +"Invalid, Try Again!!!"+Colors.RESET);
    }

    public void exit() {
        System.out.println(Colors.YELLOW+"Exiting..."+Colors.RESET);
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
        System.out.println(Colors.GREEN+"Welcome "+name+Colors.RESET);
    }

    public String getEmail() {
        System.out.print("Enter your Email : ");
        String email = input.getString();
        while(!PATTERN.matcher(email).matches()){
            System.out.print(Colors.RED+"Invalid Email, try another : "+Colors.RESET);
            email = input.getString();
        }
        return email;
    }

    public void newUserAdded() {
        System.out.println(Colors.GREEN+"---New User Added Successfully---"+Colors.RESET);
    }

    public void Login() {
        System.out.println();
        System.out.println(Colors.BG_BRIGHT_BLUE+Colors.BLACK+"---Login---"+Colors.RESET);
    }

    public void register() {
        System.out.println();
        System.out.println(Colors.BG_BLUE+Colors.BLACK+"---Register---"+Colors.RESET);
    }
}
