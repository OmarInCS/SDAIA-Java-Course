package day1.session1;

import java.util.Scanner;

public class CheckDayV2 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("Enter a day number: ");
        int day = sc.nextInt();

        if(day == 7 || day >= 1 && day <= 4) {
            System.out.println("Work-day");
        }
        else if(day == 5 || day == 6) {
            System.out.println("Off-day");
        }
        else {
            System.out.println("Invalid");
        }
    }
}
