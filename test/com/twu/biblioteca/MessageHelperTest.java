package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessageHelperTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        assertEquals(MessageHelper.getWelcomeMessage(), "Welcome to Biblioteca");
    }

    @Test
    public void shouldReturnMessageForInvalidMenuOption() {
        assertEquals(MessageHelper.getMessageForInvalidMenuOption(), "Select a valid option!");
    }

    @Test
    public void shouldReturnMessageForSuccessfulCheckout() {
        assertEquals(MessageHelper.getMessageForSuccessCheckout("book"), "Thank you! Enjoy the book");
    }

    @Test
    public void shouldReturnMessageForUnsuccessfulCheckout() {
        assertEquals(MessageHelper.getMessageForFailedCheckout("resource"), "That resource is not available.");
    }

    @Test
    public void shouldReturnMessageForSuccessfulBookReturn() {
        assertEquals(MessageHelper.getMessageForSuccessBookReturn(), "Thank you for returning the book.");
    }

    @Test
    public void shouldReturnMessageForUnsuccessfulBookReturn() {
        assertEquals(MessageHelper.getMessageForFailedBookReturn(), "That is not a valid book to return.");
    }

    @Test
    public void shouldReturnMessageForLoginRequired() {
        assertEquals(MessageHelper.getMessageForLoginRequired(), "Login required!");
    }

    @Test
    public void shouldReturnMessageForSuccessLogin() {
        assertEquals(MessageHelper.getMessageForSuccessLogin(), "Login success!");
    }

    @Test
    public void shouldReturnMessageForFailedLogin() {
        assertEquals(MessageHelper.getMessageForFailedLogin(), "Login failed!");
    }
}
