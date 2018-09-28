package com.twu.biblioteca;

public abstract class AbstractResource {

    public boolean isAvailable() {
        return available;
    }

    public String getCheckoutTo() {
        return checkoutTo;
    }

    private boolean available = true;
    private String checkoutTo;

    public void checkout(String userLibraryNumber) {
        this.available = false;
        this.checkoutTo = userLibraryNumber;
    }

    public void returned() {
        this.checkoutTo = null;
        this.available = true;
    }

    public abstract String getDetailsAsString();

    public abstract String getIdentifier();
}
