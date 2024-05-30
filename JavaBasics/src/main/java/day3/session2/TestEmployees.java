package day3.session2;

import day3.session1.Course;
import day3.session1.Employee;
import day3.session1.SalesPerson;
import day3.session1.Trainer;

public class TestEmployees {

    public static void main(String[] args) {
        Trainer t1 = new Trainer(101, "Wael", 10000);
        Course c1 = new Course("Java", 1500);
        Course c2 = new Course("Python", 1000);
        Course c3 = new Course("SQL", 1000);

        t1.addCourse(c1);
        t1.addCourse(c2);
        t1.addCourse(c3);

        System.out.println(t1.getCourses().size());
        System.out.println(t1.getCourses().get(0).getTitle());

        t1.removeCourse("SQL");
        System.out.println(t1.getCourses().size());

        SalesPerson s1 = new SalesPerson(102, "Fares", 10000, 0.1);
//        Employee e1 = new Employee(103, "Fahad", 10000);

        System.out.println("--------------");
        printEmpDetails(t1);
        System.out.println("--------------");
        printEmpDetails(s1);

    }

    public static void printEmpDetails(Employee e) {
        System.out.println(e.getName());
        System.out.println(e.getAnnualSalary());
        System.out.println(e.getTotalSalary());
//        if(e instanceof Trainer) {
//            System.out.println(((Trainer) e).getTotalSalary());
//        } else if (e instanceof SalesPerson) {
//            System.out.println(((SalesPerson) e).getTotalSalary());
//        }
    }
}
