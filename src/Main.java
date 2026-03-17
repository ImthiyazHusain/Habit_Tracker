import java.util.*;
import Controller.MainController;
import Model.*;
import Utils.Colors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Colors.YELLOW+"\n--- Habit Tracker ---"+Colors.RESET);
        MainController main = new MainController();
        main.start();
    }
}