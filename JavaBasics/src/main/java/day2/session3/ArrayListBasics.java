package day2.session3;

import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        var marks = new ArrayList<Integer>();
        marks.add(23);
        marks.add(10);
        marks.add(25);
        marks.add(13);

        System.out.println(marks);
        System.out.println(marks.get(1));
        marks.add(1, 17);
        System.out.println(marks);
        marks.set(2, 11);
        System.out.println(marks);
        marks.remove(1);
        System.out.println(marks);
        System.out.println(marks.size());
    }
}
