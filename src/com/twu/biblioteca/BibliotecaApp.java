package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
import static com.twu.biblioteca.DisplayUtils.promptMessage;

public class BibliotecaApp {

    private static final MenuHandler menuHandler = new MenuHandler();

    private static final BookListHandler bookListHandler = new BookListHandler();

    public static void main(String[] args) {

        promptMessage(MessageHelper.getWelcomeMessage());
        displayInformationWithHeader("Options:", menuHandler.getOptionListAsString());

        initializeApp();

        String userOption = menuHandler.getValidMenuOption();

        while (!MenuOption.isQuit(userOption)) {
            if (MenuOption.isMeantForBooks(userOption)) {
                bookListHandler.handleUserOption(userOption);
            }
            userOption = menuHandler.getValidMenuOption();
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
