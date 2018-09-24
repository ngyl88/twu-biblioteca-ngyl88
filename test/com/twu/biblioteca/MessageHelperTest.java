package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessageHelperTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        assertEquals(new MessageHelper().getWelcomeMessage(), "Welcome to Biblioteca");
    }
}
