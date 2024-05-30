package day3.session3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LetterCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        var fileName = sc.nextLine();
        var counts = new HashMap<Character, Integer>();

        try {
            var fsc = new Scanner(new File(fileName));
            while (fsc.hasNext()) {
                for (var c : fsc.nextLine().toLowerCase().toCharArray()) {
                    if (Character.isLetter(c)) {
                        if (counts.containsKey(c)) {
                            counts.put(c, counts.get(c) + 1);
                        } else {
                            counts.put(c, 1);
                        }
                    }
                }
            }

            for (var item : counts.entrySet()) {
                System.out.println(item.getKey() + " => " + item.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }
}
