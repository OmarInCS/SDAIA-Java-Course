package day1.session2;

import java.util.Scanner;

public class QuizV4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int correct = 0;

        for (int i = 1; i <= 5; i++) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            System.out.printf("What's %d * %d ? ", x, y);
            int answer = sc.nextInt();

            if (answer == x * y) {
                System.out.println("Correct");
                correct++;
            } else {
                System.out.println("Wrong");
            }
        }

        System.out.println("Your score is: " + correct + " out of 5");
    }

}
