package org.example.models;

public class CheckingAccount extends Account {
    public CheckingAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(double amount)
    {
        if(getBalance() - amount >= 0)
        {
            super.withdraw(amount);
        }
        else {
            throw new IllegalArgumentException("Exceeded the limit");
        }

    }

    public String toString()
    {
        return ("Hallo "+name+" your balance is: "+getBalance());
    }
}
