package day3.session1;

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

        System.out.println("--------------");
        System.out.println(t1.getName());
        System.out.println(t1.getTotalSalary());
        System.out.println(t1.getAnnualSalary());
        System.out.println(t1.getClass());
        System.out.println(t1);
        System.out.println("--------------");
        System.out.println(s1.getName());
        System.out.println(s1.getTotalSalary());
        System.out.println(s1.getAnnualSalary());



    }
}
