package com.qamp.kanita.zadatak;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner theScanner = new Scanner(System.in);

        final Owner owner1 = new Owner("Kanita", "Šabanović", "Semira Frašte");
        final Owner owner2 = new Owner("Alija", "Šabanović", "Nahorevska");

        final Account dataOfOwner1 = new Account(owner1, "ABC987", 1234, 10000);
        final Account dataOfOwner2 = new Account(owner2, "DEF432", 4321, 21353.20);

        final ATM accountsList = new ATM();
        accountsList.addAccount(dataOfOwner1);
        accountsList.addAccount(dataOfOwner2);

        while (true) {
            System.out.println("Welcome." + "\nPlease choose an option. \nPress 1 to deposit money, " +
                    "press 2 to withdraw money, press 3 to reset, and press 4 for account info, press any other number to quit: ");
            int chooseANumber = theScanner.nextInt();

            String enterSerialNumber = "";
            int enterPasscode;

            if(chooseANumber == 1){
                try {
                    System.out.println("Enter your serial number: ");
                    enterSerialNumber = theScanner.next();
                    System.out.println("Enter your passcode");
                    enterPasscode = theScanner.nextInt();
                    System.out.println("Hello " + accountsList.getNameFromSerialNumber(enterSerialNumber));
                    System.out.println("Please enter the amount you want to deposit: ");
                    double amountToDeposit = theScanner.nextDouble();
                    accountsList.deposit(amountToDeposit, enterSerialNumber, enterPasscode);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }

            else if (chooseANumber == 2){
                try {
                    System.out.println("Enter your serial number: ");
                    enterSerialNumber = theScanner.next();
                    System.out.println("Enter your passcode");
                    enterPasscode = theScanner.nextInt();
                    System.out.println("Hello " + accountsList.getNameFromSerialNumber(enterSerialNumber));
                    System.out.println("Please enter the amount you want to withdraw: ");
                    double amountToWithdraw = theScanner.nextDouble();
                    accountsList.withdraw(amountToWithdraw, enterSerialNumber, enterPasscode);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }

            else if(chooseANumber == 3){
                try {
                    System.out.println("Enter your serial number: ");
                    enterSerialNumber = theScanner.next();
                    System.out.println("Enter your passcode");
                    enterPasscode = theScanner.nextInt();
                    System.out.println("Hello " + accountsList.getNameFromSerialNumber(enterSerialNumber));
                    accountsList.reset(enterSerialNumber, enterPasscode);
                    System.out.println("Your account has been reset");
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(chooseANumber == 4){
                try {
                    System.out.println("Enter your serial number: ");
                    enterSerialNumber = theScanner.next();
                    System.out.println("Enter your passcode");
                    enterPasscode = theScanner.nextInt();
                    System.out.println("Hello " + accountsList.getNameFromSerialNumber(enterSerialNumber));
                    String accState = accountsList.showAccountState(enterSerialNumber, enterPasscode);
                    System.out.println(accState);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println("Goodbye!");
            }

        }
    }
}
