package day2.session3;

public class TestStudent {

    public static void main(String[] args) {
        var s1 = new Student("Ahmed", 23);
        var s2 = new Student("Wael", 15);

//        s1.fullMark = 25;
        Student.fullMark = 25;
//        s1.mark = -23;
        s1.setMark(-25);

        System.out.println(s1.name);
        System.out.println(s1.getPercent());
        System.out.println(s1.getGrade());
        System.out.println("----------");
        System.out.println(s2.name);
        System.out.println(s2.getPercent());
        System.out.println(s2.getGrade());
    }

}
