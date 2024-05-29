package day2.session1;

import java.util.Arrays;
import java.util.Scanner;

public class CallMethods {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.print("Enter weight and height: ");
        double w = sc.nextDouble();
        double h = sc.nextDouble();

        double bmi = MyMethods.calcBMI(w, h);
        String status = MyMethods.getStatus(bmi);

        System.out.println("Your BMI: " + bmi + ", " + status);

//        var statuses = MyMethods.getStatus(new double[] {23, 20, 35, 15});
        var statuses = MyMethods.getStatus(23, 20, 35, 15);
        System.out.println(Arrays.toString(statuses));
    }

}
