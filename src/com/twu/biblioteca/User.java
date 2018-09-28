package com.twu.biblioteca;

public class User {

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this(libraryNumber, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean checkPassword(String input) {
        return this.password.equals(input);
    }

    public String getUserInformationInString() {

        StringBuilder tempSB = new StringBuilder();
        tempSB.append("- Name: " + this.getName());
        tempSB.append("\t\t\tEmail: " + this.getEmail());
        tempSB.append("\t\t\tPhone: " + this.getPhoneNumber());

        return tempSB.toString();

    }
}
