package Utils;

import java.util.Scanner;

public class inputs {
    Scanner sc = new Scanner(System.in);
    public int getInt(){
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    public String getString() {
        return sc.nextLine();
    }
}
