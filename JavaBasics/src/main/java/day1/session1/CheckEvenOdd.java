package day1.session1;

import java.util.Scanner;

public class CheckEvenOdd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enetr a number: ");
        int x = sc.nextInt();

        System.out.println(x % 2 == 0 ? "Even" : "Odd");
    }
}
