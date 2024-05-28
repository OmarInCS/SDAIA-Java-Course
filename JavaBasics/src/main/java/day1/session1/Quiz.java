package day1.session1;

import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
//        System.out.println("What's " + x + " * " + y + " ?");
        System.out.printf("What's %d * %d ? ", x, y);
        int answer = sc.nextInt();

        if (answer == x*y) {
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
        }
    }

}
