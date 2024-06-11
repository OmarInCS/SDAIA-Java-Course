package org.example.models;

public class SavingAccount extends Account {

    private int limit;

    public SavingAccount(String name, double balance, int limit) {
        super(name, balance);
        this.limit = limit;
    }

    @Override
    public void withdraw(double amount)
    {
        if(getBalance() - amount >= limit)
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
