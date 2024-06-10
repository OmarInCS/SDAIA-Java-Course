package org.example.models;

public class Account {
    String name;
    private double balance;
    public static double annualRate = 0.04;

    public Account(String name, double balance)
    {
        this.name=name;
        this.balance=balance;
    }

    public static double getMonthlyRate()
    {
        return annualRate/12;
    }

    public double getMonthlyInt()
    {
        return balance*getMonthlyRate();
    }

    public void deposit(double amaunt)
    {
        balance+=amaunt;
    }

    public void withdraw(double amaunt)
    {
        balance-=amaunt;
    }

    public double getBalance()
    {
        return balance;
    }

    public String toString()
    {
        return ("Hallo "+name+" your balance is: "+balance+" and monthly rate int: "+getMonthlyInt());
    }
}
