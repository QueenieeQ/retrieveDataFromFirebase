package com.example.relatimedatabase;

public class Users {

    String firstName, lastName, age;
    String dateOfBirth, email, gender, occupation, userName, userNumber;

    public Users() {
    }

    public Users(String dateOfBirth, String email, String gender, String occupation, String userName, String userNumber) {

        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.gender = gender;
        this.occupation = occupation;
        this.userNumber = userNumber;

    }

    public Users(String firstName, String lastName, String age, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getuserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
