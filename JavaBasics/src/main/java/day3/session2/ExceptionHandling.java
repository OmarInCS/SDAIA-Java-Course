package day3.session2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two number: ");
        try {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("Result: " + x / y);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Recheck your inputs");
        }
//        catch (ArithmeticException ex) {
//            System.out.println("Can't divide by zero");
//        }
//        catch (InputMismatchException ex) {
//            System.out.println("only int are allowed");
//        }
        System.out.println("== Good Bye ==");


    }



}
