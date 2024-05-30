package day3.session3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortWordsInNewFile {

    public static void main(String[] args) {

        var f1 = new File("C:\\Users\\Mr Omar\\Desktop\\words.txt");
        var fileName = "src/main/java/day3/session3/sorted_words.txt";
        var words = new ArrayList<String>();

        try (var fsc = new Scanner(f1);
             var pr = new PrintWriter(fileName);) {

            while (fsc.hasNext()) {
                words.add(fsc.nextLine());
            }

            Collections.sort(words);


            for (var w : words) {
                pr.println(w);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }



    }
}
