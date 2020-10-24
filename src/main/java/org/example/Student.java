package org.example;


import java.util.regex.*;
import java.lang.Throwable;

public class Student {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String id;
    private int age;
    private final int currentYear = 2020;

    public Student(String firstName, String lastName, String gender, String birthDate, String id) {

        if (firstName == "" || lastName == "" || firstName.matches("\\d") || lastName.matches("\\d")) {
            System.out.println("Exception catched because of incorect name");
            throw new IllegalArgumentException("Incorrect format for First Name or/and Last Name");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        setGender(gender);
        setBirthDate(birthDate);
        setId(id);
    }

    public void setBirthDate(String birthDate) {

        if(birthDate.matches("^(19|20)\\d\\d[-\\/\\.](0[1-9]|1[012])[-\\/\\.](0[1-9]|1[0-9]|2[0-9]|3[01])$")) {
            this.birthDate = birthDate;
            int birthYear = Integer.parseInt(birthDate.substring(0,4));
            calculateAge(birthYear);
        } else {
            throw new IllegalArgumentException("Incorrect format for birthdate");
        }
    }

    public void setGender(String gender) {
        if ( (gender.toLowerCase().contains("m") || gender.toLowerCase().contains("male")) ||
                (gender.toLowerCase().contains("f") || gender.toLowerCase().contains("female")) ) {
            this.gender = gender;
        }
        else throw new IllegalArgumentException("Invalid gender format");
    }

    public void setId (String id) {
        if(id.matches("\\b[1-8]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)\\d{4}\\b")) {
            this.id = id;
        }
        else {
            throw new IllegalArgumentException("Wrong format for ID");
        }
    }

    private void calculateAge(int birthYear ) {
        this.age = currentYear - birthYear;

        if (age < 0) {
            throw new IndexOutOfBoundsException("Birth date error: age is negative");
        }
    }

    public String getName() {
        return this.lastName + " " + this.firstName;
    }

    public String getId() {
        return this.id;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public String getBirthDate() {
        return birthDate;
    }

}


