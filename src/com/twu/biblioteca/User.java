package com.twu.biblioteca;

public class User {

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean checkPassword(String input) {
        return this.password.equals(input);
    }
}
