package com.qamp.kanita.zadatak;

public class Account {
    private Owner theOwner;
    private String serialNumber;
    private int passCode;
    public double balance;

    public Account(final Owner theOwner, final String serialNumber, final int passCode, final double balance) {
        this.theOwner = theOwner;
        this.serialNumber = serialNumber;
        if(passCode < 1000 || passCode > 9999){
            throw new IllegalArgumentException("Invalid passcode");
        }
        this.passCode = passCode;
        this.balance = balance;
    }

    public String getTheOwner(){
        return theOwner.toString();
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    public int getPasscode(){
        return passCode;
    }

    public double withdraw(double amount) {
        this.balance = this.balance - amount;
        return amount;
    }

    public double deposit(double amount) {
        this.balance = this.balance + amount;
        return amount;
    }

    public void reset(){}

    public String accountBalanceState() {
        return "The Owner: \n" + theOwner.toString() + "; has $" + this.balance + " in his/her bank account.";
    }

    public Owner getName() {
        return theOwner;
    }

    public String getFirstName(){
        return theOwner.getNameAndSurname();
    }
}
