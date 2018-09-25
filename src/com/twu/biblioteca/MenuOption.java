package com.twu.biblioteca;

public enum MenuOption {
    LIST_BOOK("1", "List Books"),
    QUIT("q", "Quit");

    public static boolean isQuit(String userOption) {
        return QUIT.getOptionKey().equals(userOption);
    }

    public static boolean isListBook(String userOption) {
        return LIST_BOOK.getOptionKey().equals(userOption);
    }

    public String getOptionKey() {
        return optionKey;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    private final String optionKey;
    private final String optionDescription;

    MenuOption(String key, String description) {
        this.optionKey = key;
        this.optionDescription = description;
    }
}
