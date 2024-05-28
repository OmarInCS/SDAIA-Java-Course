package day1.session3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AnalyzeMarks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int n = sc.nextInt();
        double best = 0;

        double[] marks = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter std. mark: ");
            marks[i] = sc.nextDouble();
            if (marks[i] > best) {
                best = marks[i];
            }
        }

//        for (int i = 0; i < marks.length; i++) {
//            if(marks[i] >= best - 10) {
//                System.out.println(marks[i] + " => A");
//            }
//            else if(marks[i] >= best - 20) {
//                System.out.println(marks[i] + " => B");
//            }
//            else if(marks[i] >= best - 30) {
//                System.out.println(marks[i] + " => C");
//            }
//            else if(marks[i] >= best - 40) {
//                System.out.println(marks[i] + " => D");
//            }
//            else {
//                System.out.println(marks[i] + " => F");
//            }
//
//        }

        for (double m : marks) {
            if(m >= best - 10) {
                System.out.println(m + " => A");
            }
            else if(m >= best - 20) {
                System.out.println(m + " => B");
            }
            else if(m >= best - 30) {
                System.out.println(m + " => C");
            }
            else if(m >= best - 40) {
                System.out.println(m + " => D");
            }
            else {
                System.out.println(m + " => F");
            }

        }


    }
}
