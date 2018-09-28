package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
import static com.twu.biblioteca.DisplayUtils.promptMessage;

public class BibliotecaApp {

    private static final MenuHandler MENU_HANDLER = new MenuHandler();

    private static final ResourceHandler RESOURCE_HANDLER = new ResourceHandler();

    private static final UserManager USER_MANAGER = new UserManager();

    public static void main(String[] args) {

        promptMessage(MessageHelper.getWelcomeMessage());

        displayInformationWithHeader("Options:", MENU_HANDLER.getOptionListAsString());

        initializeApp();

        String userOption = MENU_HANDLER.getValidMenuOption(USER_MANAGER.getLoginStatus());

        while (!MenuOption.QUIT.keyMatches(userOption)) {

            if(MenuOption.LOGIN.keyMatches(userOption)) {
                USER_MANAGER.handleLogin();
            }

            RESOURCE_HANDLER.handleUserOption(userOption, USER_MANAGER.getCurrentUserLibraryNumber());

            userOption = MENU_HANDLER.getValidMenuOption(USER_MANAGER.getLoginStatus());

        }

        exitApp();
    }

    private static void exitApp() {
        InputUtils.closeStream();
        System.exit(0);
    }

    private static void initializeApp() {
        InputUtils.openStream();
    }
}
