package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.promptMessage;
import static com.twu.biblioteca.InputUtils.getInputFromUser;

public class UserManager {

    private final UserList userList = new UserList();

    private User currentUser;

    public boolean login(String libraryNumber, String password) {
        boolean loginSuccess = userList.checkLoginCredentials(libraryNumber, password);

        if (loginSuccess) {
            this.currentUser = userList.getUserByLibraryNumber(libraryNumber);
        }

        return loginSuccess;
    }

    public boolean getLoginStatus() {
        return this.currentUser != null;
    }

    public String getCurrentUserLibraryNumber() {
        if (this.currentUser == null) {
            return null;
        }
        return this.currentUser.getLibraryNumber();
    }

    // TODO: UNIT TEST NOT CREATED (support main)
    public void handleLogin() {

        String libraryNumber = getInputFromUser("Please enter your library number: ");
        String password = getInputFromUser("Please enter your password: ");

        if(login(libraryNumber, password)) {
            promptMessage(MessageHelper.getMessageForSuccessLogin());
        } else {
            promptMessage(MessageHelper.getMessageForFailedLogin());
        }

    }
}
