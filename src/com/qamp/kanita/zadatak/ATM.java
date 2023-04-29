package com.qamp.kanita.zadatak;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private List<Account> accounts;

    public ATM() {
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account theAccount){
        this.accounts.add(theAccount);
    }

    public double withdraw(double withdrawAmount, String serialNumber, int passcode){
        Account theAccount = insertAccount(serialNumber, passcode);
        theAccount.withdraw(withdrawAmount);
        return withdrawAmount;
    }

    public double deposit(double amountToDeposit, String serialNumber, int passcode){
        Account theAccount = insertAccount(serialNumber, passcode);
        theAccount.deposit(amountToDeposit);
        return amountToDeposit;
    }

    public void reset(String serialNumber, int passcode){
        Account theAccount = insertAccount(serialNumber, passcode);
        theAccount.reset();
    }

    public Account insertAccount(String serialNumber, int passcode) {
        for (Account account : accounts) {
            if (account.getSerialNumber().equals(serialNumber)) {
                if (account.getPasscode() != passcode) {
                    throw new IllegalStateException("Incorrect passcode. Please try again.");
                }
                return account;
            }
        }
        throw new IllegalStateException("Wrong serial number. Please try again.");
    }

    public String showAccountState(String serialNumber, int passcode){
        Account theAccount = insertAccount(serialNumber, passcode);
        return theAccount.accountBalanceState();
    }

    public String getNameFromSerialNumber(String serialNumber){
        for (Account account : accounts) {
            if (account.getSerialNumber().equals(serialNumber)) {
                return account.getFirstName();
            }
        }
        throw new IllegalStateException("No account found with serial number " + serialNumber);
    }





}
