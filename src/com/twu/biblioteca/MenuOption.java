package com.twu.biblioteca;

public enum MenuOption {
    LIST_OPTIONS("0", "List Options", false),
    LOGIN("in", "Login", false),
    VIEW_USER_INFO("i", "View user information", true),
    LIST_BOOK("1", "List Books", false),
    CHECKOUT_BOOK("2", "Checkout Book", true),
    RETURN_BOOK("3", "Return Book", true),
    LIST_MOVIE("4", "List Movies", false),
    CHECKOUT_MOVIE("5", "Checkout Movie", true),
    QUIT("q", "Quit", false);

    public boolean keyMatches(String userOption) {
        return this.getOptionKey().equals(userOption);
    }

    public String getOptionKey() {
        return optionKey;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public boolean isLoginRequired() {
        return loginRequired;
    }

    private final String optionKey;
    private final String optionDescription;

    private final boolean loginRequired;

    MenuOption(String key, String description, boolean loginRequired) {
        this.optionKey = key;
        this.optionDescription = description;
        this.loginRequired = loginRequired;
    }
}
