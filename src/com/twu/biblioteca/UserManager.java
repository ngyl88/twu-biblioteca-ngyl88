package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
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
        return currentUser != null;
    }

    public String getCurrentUserLibraryNumber() {
        if (this.currentUser == null) {
            return null;
        }
        return currentUser.getLibraryNumber();
    }

    public String getCurrentUserInformation() {
        if (currentUser == null) return "";

        return currentUser.getUserInformationInString();
    }

    // TODO: UNIT TEST NOT CREATED (support main)
    private void handleLogin() {

        String libraryNumber = getInputFromUser("Please enter your library number: ");
        String password = getInputFromUser("Please enter your password: ");

        if (login(libraryNumber, password)) {
            promptMessage(MessageHelper.getMessageForSuccessLogin());
        } else {
            promptMessage(MessageHelper.getMessageForFailedLogin());
        }

    }

    // TODO: to add unit test (refactored)
    public boolean isUserOptionInScope(String userOption) {

        return MenuOption.LOGIN.keyMatches(userOption) || MenuOption.VIEW_USER_INFO.keyMatches(userOption);

    }

    // TODO: UNIT TEST NOT CREATED (support main)
    public void handleUserOption(String userOption) {

        if (MenuOption.VIEW_USER_INFO.keyMatches(userOption)) {
            displayInformationWithHeader("User Information:", getCurrentUserInformation());

        } else if (MenuOption.LOGIN.keyMatches(userOption)) {
            handleLogin();

        }

    }
}
