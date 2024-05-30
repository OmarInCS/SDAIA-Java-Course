package day3.session3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileRW {

    public static void main(String[] args) {

        var f1 = new File("C:\\Users\\Mr Omar\\Desktop\\words.txt");
        System.out.println(f1.length());
        System.out.println(f1.exists());
        System.out.println(f1.isDirectory());
        System.out.println("---------------");

        try {
            var fsc = new Scanner(f1);
            while (fsc.hasNext()) {
                System.out.println(fsc.nextLine());
            }

            fsc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        var fileName = "src/main/java/day3/session3/sorted_words.txt";
        try {
            var pr = new PrintWriter(fileName);
            pr.println("Omar");

            pr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect path");
        }

    }
}
