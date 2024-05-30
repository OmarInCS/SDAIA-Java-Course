package day3.session1;

import java.util.ArrayList;

public class Trainer extends Employee {

    private double overtime;
    private ArrayList<Course> courses;

    public Trainer(int id, String name, double salary) {
        super(id, name, salary);
        courses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void removeCourse(String title) {
        for (var c : courses) {
            if(c.getTitle().equals(title)) {
                courses.remove(c);
                return;
            }
        }
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public double getTotalSalary() {
        return getSalary() + overtime;
    }
}
