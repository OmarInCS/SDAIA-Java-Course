package day2.session1;

public class MyMethods {

    public static double calcBMI(double weight
                                , double height) {
        return weight / Math.pow(height / 100, 2);
    }

    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static String[] getStatus(double... bmis) {
        var statuses = new String[bmis.length];
        for (int i = 0; i < bmis.length; i++) {
            var bmi = bmis[i];
            if (bmi < 18.5) statuses[i] = "Underweight";
            else if (bmi < 25) statuses[i] = "Normal";
            else if (bmi < 30) statuses[i] = "Overweight";
            else statuses[i] = "Obese";
        }

        return statuses;
    }


}
