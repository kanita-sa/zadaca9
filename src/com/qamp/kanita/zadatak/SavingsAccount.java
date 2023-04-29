package com.qamp.kanita.zadatak;

public class SavingsAccount extends Account{

    private int noOfTransactions;
    private double dailyLimit;
    public SavingsAccount(Owner theOwner, String serialNumber, int passCode, double balance) {
        super(theOwner, serialNumber, passCode, balance);
    }

    public double withdraw(double withdrawAmount){
        if(noOfTransactions <= 3){
            throw new IllegalStateException("Limit of daily transactions exceeded");
        }
        if(dailyLimit > 1000){
            throw new IllegalStateException("Limit of daily amount of transaction exceeded");
        }
        if(withdrawAmount > balance){
            throw new IllegalStateException("Not enough money on your account");
        }
        dailyLimit = dailyLimit - withdrawAmount;
        noOfTransactions = noOfTransactions - 1;
        return withdrawAmount;
    }

    public double deposit (double amountToDeposit){
        dailyLimit = dailyLimit + amountToDeposit;
        return amountToDeposit;
    }

    public void reset(){
        noOfTransactions = 3;
        dailyLimit = 1000;
    }

    public String showAccountState(){
        return super.accountBalanceState() + "\n Current daily limit: " + dailyLimit + "\n Number of available" +
                "transactions: " + noOfTransactions;
    }

}
