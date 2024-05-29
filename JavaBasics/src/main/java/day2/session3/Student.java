package day2.session3;

public class Student {
    String name;
    private double mark;
    static int fullMark;

    public Student(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }

    public double getPercent() {
        return mark / fullMark * 100;
    }

    public String getGrade() {
        double pct = getPercent();
        if(pct > 85) return "Excellent";
        else if (pct > 75) return "V. Good";
        else if (pct > 65) return "Good";
        else if (pct >= 50) return "Pass";
        else return "Fail";
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double value) {
        if(value >= 0) {
            this.mark = value;
        }
    }

}
