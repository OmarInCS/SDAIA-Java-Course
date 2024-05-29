package day2.session2;

public class TestPatient {

    public static void main(String[] args) {

//        Patient x = new Patient("Ahmed", 75, 175);
        Patient y = new Patient("Wael", 75, 165);
        Patient x = new Patient();
        System.out.println(x.name);
        x.name = "Ahmed";
        x.weight = 75;
        x.height = 175;

        System.out.println(x.name);
        System.out.println(x.calcBMI());
        System.out.println(x.getStatus());
        System.out.println("---------------");
        System.out.println(y.name);
        System.out.println(y.calcBMI());
        System.out.println(y.getStatus());

    }

}
