package day1.session2;

import java.util.Scanner;

public class QuizV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);
        System.out.printf("What's %d * %d ? ", x, y);
        int answer = sc.nextInt();

        while (answer == x*y) {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            System.out.printf("What's %d * %d ? ", x, y);
            answer = sc.nextInt();
        }

        System.out.println("Game Over!!");

    }
}
