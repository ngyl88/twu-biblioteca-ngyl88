package com.twu.biblioteca;

public enum MenuOption {
    LIST_BOOK("1", "List Books"),
    QUIT("q", "Quit");

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
