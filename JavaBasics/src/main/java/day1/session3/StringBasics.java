package day1.session3;

public class StringBasics {

    public static void main(String[] args) {
        String name = "Omar";
        String phone = "0501512521";
        String email = "ok@gmail.com";
        String message = "Welcome to Java";

        System.out.println(name.length());
        System.out.println(name.charAt(1));
        System.out.println(message.substring(0, 7));

        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());

        System.out.println(email.endsWith(".com"));
        System.out.println(phone.startsWith("05"));
        System.out.println(email.contains("@"));

        char grade = 'A';
        System.out.println(Character.isUpperCase(grade));
        System.out.println(Character.isLetter(grade));
        System.out.println(Character.isDigit(grade));
    }

}
