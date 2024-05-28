package day1.session2;

public class LoopBasics {
    public static void main(String[] args) {

        int x = 1;
        while (x <= 10) {
            System.out.print(x + "\t");
            x += 1;
        }
        System.out.println();
        System.out.println("--------------");

        int y = 1;
        do {
            System.out.print(y + "\t");
            y += 1;
        } while (y <= 10);
        System.out.println();
        System.out.println("--------------");

        for (int z = 1; z <= 10; z++) {
            System.out.print(z + "\t");
        }
        System.out.println();
        System.out.println("--------------");

        for (int z = 1; z <= 10; z++) {
            if(z == 5) {
                break;
            }
            System.out.print(z + "\t");
        }
        System.out.println();
        System.out.println("--------------");

        for (int z = 1; z <= 10; z++) {
            if(z == 5) {
                continue;
            }
            System.out.print(z + "\t");
        }
        System.out.println();
        System.out.println("--------------");
    }
}
