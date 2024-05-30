package day3.session2;

import java.util.Scanner;

public class ExceptionHandlingV2 {

    public static void main(String[] args) {

        Student s1 = new Student("Wael", 23);

        System.out.print("Enter two number: ");
        try {
            printResult();
            s1.setMark(-25);
            System.out.println(s1.name + ": " + s1.getPercent());
        }
        catch (InvalidMarkException e) {
            System.out.println("Your custom error");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("== Good Bye ==");


    }

    public static void printResult() throws Exception {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("Result: " + x / y);
    }

}
