import Controller.MainController;

import static Utils.Colors.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(DEFAULT);
        System.out.println(BRIGHT_YELLOW+"--- Habit Tracker ---"+ DEFAULT);
        MainController main = new MainController();
        main.start();
        System.out.println(RESET);
    }
}