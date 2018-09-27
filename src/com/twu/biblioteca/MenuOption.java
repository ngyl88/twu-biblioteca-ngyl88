package com.twu.biblioteca;

public enum MenuOption {
    LIST_BOOK("1", "List Books"),
    CHECKOUT_BOOK("2", "Checkout Book"),
    RETURN_BOOK("3", "Return Book"),
    LIST_MOVIE("4", "List Movies"),
    QUIT("q", "Quit");

    public static boolean isMeantForBooks(String userOption) {
        return LIST_BOOK.keyMatches(userOption) || CHECKOUT_BOOK.keyMatches(userOption) || RETURN_BOOK.keyMatches(userOption);
    }

    public boolean keyMatches(String userOption) {
        return this.getOptionKey().equals(userOption);
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
