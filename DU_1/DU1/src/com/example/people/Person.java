package com.example.people;

import com.example.people.identification.Passport;

public class Person {
    private static final String DEFAULT_DATE_OF_BIRTH = "nezadano";

    private String givenName;
    private String surname;
    private String dateOfBirth;
    private Passport passport;

    public Person (String givenName, String surname) {
        this(givenName, surname, DEFAULT_DATE_OF_BIRTH);
    }

    public Person(String givenName, String surname, String dateOfBirth) {
        this.givenName = givenName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
