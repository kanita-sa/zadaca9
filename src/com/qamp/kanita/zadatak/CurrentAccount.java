package com.qamp.kanita.zadatak;

public class CurrentAccount extends Account {

    public CurrentAccount(Owner theOwner, String serialNumber, int passCode, double balance) {
        super(theOwner, serialNumber, passCode, balance);
    }

   @Override
    public double withdraw(double amountToWithdraw){
        balance = balance - amountToWithdraw;
        return amountToWithdraw;
    }
    @Override
    public double deposit(double amountToDeposit){
        balance = balance + amountToDeposit;
        return amountToDeposit;
    }

    public void reset(){
    }

    public String showAccountState(){
        return super.accountBalanceState();
    }

}
