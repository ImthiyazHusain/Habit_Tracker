package Utils;

import java.util.Scanner;

import static Utils.Colors.*;

public class inputs {
    static Scanner sc = new Scanner(System.in);
    public static int getInt(){
        int input;
        try{
            input = sc.nextInt();
            sc.nextLine();
            return input;
        }catch (Exception e) {
            System.out.print(BG_RED+BLACK+"Invalid input type!!!"+RESET+DEFAULT +"\nEnter again : ");
            sc.nextLine();
            return getInt();
        }
    }

    public static String getString() {
        return sc.nextLine();
    }
}
