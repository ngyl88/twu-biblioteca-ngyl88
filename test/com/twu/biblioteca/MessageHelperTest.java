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
}
