package com.twu.biblioteca;

public enum MenuOption {
    LIST_BOOK("1", "List Books"),
    CHECKOUT_BOOK("2", "Checkout Book"),
    RETURN_BOOK("3", "Return Book"),
    QUIT("q", "Quit");

    public static boolean isQuit(String userOption) {
        return QUIT.getOptionKey().equals(userOption);
    }

    public static boolean isListBook(String userOption) {
        return LIST_BOOK.getOptionKey().equals(userOption);
    }

    public static boolean isCheckoutBook(String userOption) {
        return CHECKOUT_BOOK.getOptionKey().equals(userOption);
    }

    public static boolean isReturnBook(String userOption) {
        return RETURN_BOOK.getOptionKey().equals(userOption);
    }

    public static boolean isMeantForBooks(String userOption) {
        return isListBook(userOption) || isCheckoutBook(userOption) || isReturnBook(userOption);
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
