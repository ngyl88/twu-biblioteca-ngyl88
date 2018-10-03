package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
import static com.twu.biblioteca.DisplayUtils.promptMessage;

public class BibliotecaApp {

    private MenuHandler menuHandler = new MenuHandler();

    private ResourceHandler resourceHandler = new ResourceHandler();

    private UserManager userManager = new UserManager();

    private void initialize() {
        InputUtils.openStream();
    }

    private void exit() {
        InputUtils.closeStream();
        System.exit(0);
    }

    private void handleUserOption(String userOption) {

        if (MenuOption.LIST_OPTIONS.keyMatches(userOption)) {

            boolean loggedIn = userManager.getLoginStatus();
            displayInformationWithHeader("Options:", menuHandler.getOptionListAsString(loggedIn));

        } else if (userManager.isUserOptionInScope(userOption)) {

            userManager.handleUserOption(userOption);

        } else if (resourceHandler.isUserOptionInScope(userOption)) {

            String userLibraryNumber = userManager.getCurrentUserLibraryNumber();
            resourceHandler.handleUserOption(userOption, userLibraryNumber);

        }

    }

    private void run() {

        promptMessage(MessageHelper.getWelcomeMessage());

        displayInformationWithHeader("Options:", menuHandler.getOptionListAsString(false));

        initialize();

        String userOption = menuHandler.getValidMenuOption(userManager.getLoginStatus());

        while (!MenuOption.QUIT.keyMatches(userOption)) {

            handleUserOption(userOption);

            userOption = menuHandler.getValidMenuOption(userManager.getLoginStatus());

        }

        exit();

    }

    public static void main(String[] args) {

        new BibliotecaApp().run();

    }
}
