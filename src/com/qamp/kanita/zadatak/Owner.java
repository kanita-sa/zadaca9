package com.qamp.kanita.zadatak;

public class Owner {
    public String firstName;
    public String lastName;
    private String address;

    public Owner(final String firstName, final String lastName, final String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getNameAndSurname(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "name: " + firstName + "; last name: " + lastName + "; with the address: " + address;
    }

}
