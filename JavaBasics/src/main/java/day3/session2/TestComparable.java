package day3.session2;

import java.util.ArrayList;
import java.util.Collections;

public class TestComparable {

    public static void main(String[] args) {
        var marksLst = new ArrayList<Double>();
        marksLst.add(23.5);
        marksLst.add(20.0);
        marksLst.add(25.0);

        var namesLst = new ArrayList<String>();
        namesLst.add("Wael");
        namesLst.add("Ahmed");
        namesLst.add("Zaid");

        Collections.sort(marksLst);
        Collections.sort(namesLst);

        System.out.println(marksLst);
        System.out.println(namesLst);

        var coursesList = new ArrayList<Course>();
        coursesList.add(new Course("Java", 1500));
        coursesList.add(new Course("Python", 1000));
        coursesList.add(new Course("SQL", 1200));

        Collections.sort(coursesList);
        System.out.println(coursesList);
    }
}
