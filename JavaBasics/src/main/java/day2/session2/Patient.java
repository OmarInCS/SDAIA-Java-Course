package day2.session2;

public class Patient {
    String name;
    double weight;
    double height;

    public Patient() {
        this("Unknown", 70, 170);
//        name = "Unknown";
//        weight = 70;
//        height = 170;
    }

    public Patient(String name, double weight, double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public double calcBMI() {
        return weight / Math.pow(height / 100, 2);
    }

    public String getStatus() {
        double bmi = calcBMI();
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

}
