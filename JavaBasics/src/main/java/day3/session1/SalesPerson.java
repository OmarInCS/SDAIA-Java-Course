package day3.session1;

public class SalesPerson extends Employee {

    private double comm;

    public SalesPerson(int id, String name, double salary, double comm) {
        super(id, name, salary);
        this.comm = comm;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public double getTotalSalary() {
        return getSalary() + getSalary() * comm;
    }
}
