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
    public void shouldReturnMessageForSuccessfulBookCheckout() {
        assertEquals(MessageHelper.getMessageForSuccessBookCheckout(), "Thank you! Enjoy the book");
    }

    @Test
    public void shouldReturnMessageForUnsuccessfulBookCheckout() {
        assertEquals(MessageHelper.getMessageForFailedBookCheckout(), "That book is not available.");
    }

    @Test
    public void shouldReturnMessageForSuccessfulBookReturn() {
        assertEquals(MessageHelper.getMessageForSuccessBookReturn(), "Thank you for returning the book.");
    }
}
