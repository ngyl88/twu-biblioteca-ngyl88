package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuHandlerTest {

    @Test
    public void shouldBeCreatedWithOptions() {
        assertTrue(new MenuHandler().getOptions().size() > 0);
    }

    @Test
    public void shouldBeCreatedWithListBookOption() {
        assertTrue(new MenuHandler().getOptions().containsValue("List Books"));
    }

}