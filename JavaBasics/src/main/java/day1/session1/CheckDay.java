package day1.session1;

import java.util.Scanner;

public class CheckDay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a day number: ");
        int day = sc.nextInt();

        if (day >= 1 && day <= 5) {
            System.out.println("Work-day");
        }
        else if (day == 6 || day == 7) {
            System.out.println("Off-day");
        }
        else {
            System.out.println("Invalid input");
        }


        switch (day) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
        }

        switch (day) {
            case 1 ->
                System.out.println("Sunday");
            case 2 ->
                System.out.println("Monday");
            case 3 ->
                System.out.println("Tuesday");
            case 4 ->
                System.out.println("Wednesday");
            case 5 ->
                System.out.println("Thursday");
            case 6 ->
                System.out.println("Friday");
            case 7 ->
                System.out.println("Saturday");
        }

//        String dayName = switch (day) {
//            case 1 -> ("Sunday");
//            case 2 -> ("Monday");
//            case 3 -> ("Tuesday");
//            case 4 -> ("Wednesday");
//            case 5 -> ("Thursday");
//            case 6 -> ("Friday");
//            case 7 -> ("Saturday");
//            default -> "Not a day";
//        };

        String dayName = switch (day) {
            case 1: yield ("Sunday");
            case 2: yield ("Monday");
            case 3: yield ("Tuesday");
            case 4: yield ("Wednesday");
            case 5: yield ("Thursday");
            case 6: yield ("Friday");
            case 7: yield ("Saturday");
            default: yield "Not a day";
        };

    }

}
