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

    private void run() {

        promptMessage(MessageHelper.getWelcomeMessage());

        displayInformationWithHeader("Options:", menuHandler.getOptionListAsString());

        initialize();

        String userOption = menuHandler.getValidMenuOption(userManager.getLoginStatus());

        while (!MenuOption.QUIT.keyMatches(userOption)) {

            userManager.handleUserOption(userOption);

            resourceHandler.handleUserOption(userOption, userManager.getCurrentUserLibraryNumber());

            userOption = menuHandler.getValidMenuOption(userManager.getLoginStatus());

        }

        exit();

    }

    public static void main(String[] args) {

        new BibliotecaApp().run();

    }
}
