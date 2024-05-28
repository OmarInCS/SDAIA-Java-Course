package day1.session3;

import java.util.Scanner;

public class PasswordChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a new password: ");
        String password = sc.nextLine();

        if(password.length() < 8) {
            System.out.println("Week Password");
        }
        else {
            int digitCount = 0;
            int upperCount = 0;

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    upperCount++;
                }
                else if (Character.isDigit(c)) {
                    digitCount++;
                }
            }

            if (upperCount < 2 || digitCount < 2) {
                System.out.println("Weak Password");
            }
            else {
                System.out.println("Strong Password");
            }
        }
    }
}
