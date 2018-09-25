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

    @Test
    public void shouldBeAbleToReturnOptionListAsString() {
        MenuHandler menuHandler = new MenuHandler();
        assertNotEquals(menuHandler.getOptionListAsString(), "");
    }

    @Test
    public void shouldIdentifyInvalidOption() {
        MenuHandler menuHandler = new MenuHandler();
        assertTrue(menuHandler.isInvalidOption("999"));
    }

    @Test
    public void shouldIdentifyValidOption() {
        MenuHandler menuHandler = new MenuHandler();
        assertFalse(menuHandler.isInvalidOption("1"));
    }

}