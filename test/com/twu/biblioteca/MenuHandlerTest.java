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
        assertTrue(new MenuHandler().getOptions().containsValue(MenuOption.LIST_BOOK));
    }

    @Test
    public void shouldBeAbleToReturnOptionListAsString() {
        MenuHandler menuHandler = new MenuHandler();
        assertNotEquals(menuHandler.getOptionListAsString(), "");
    }

    @Test
    public void invalidOptionShouldBeInvalid() {
        MenuHandler menuHandler = new MenuHandler();
        assertFalse(menuHandler.isValidOptionBasedOnLoginStatus("XYZ", true));
        assertFalse(menuHandler.isValidOptionBasedOnLoginStatus("XYZ", false));
    }

    @Test
    public void optionsNotRequiredLoginShouldBeValidRegardlessOfLoginStatus() {
        MenuHandler menuHandler = new MenuHandler();
        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.LOGIN.getOptionKey(), true));
        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.LOGIN.getOptionKey(), false));

        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.LIST_BOOK.getOptionKey(), true));
        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.LIST_BOOK.getOptionKey(), false));

        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.LIST_MOVIE.getOptionKey(), true));
        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.LIST_MOVIE.getOptionKey(), false));

        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.QUIT.getOptionKey(), true));
        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.QUIT.getOptionKey(), false));
    }

    @Test
    public void optionsRequiredLoginShouldBeInvalidIfNotLoggedIn() {
        MenuHandler menuHandler = new MenuHandler();
        assertFalse(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.CHECKOUT_BOOK.getOptionKey(), false));
        assertFalse(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.CHECKOUT_MOVIE.getOptionKey(), false));
        assertFalse(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.RETURN_BOOK.getOptionKey(), false));
    }

    @Test
    public void optionsRequiredLoginShouldBeValidIfLoggedIn() {
        MenuHandler menuHandler = new MenuHandler();
        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.CHECKOUT_BOOK.getOptionKey(), true));
        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.CHECKOUT_MOVIE.getOptionKey(), true));
        assertTrue(menuHandler.isValidOptionBasedOnLoginStatus(MenuOption.RETURN_BOOK.getOptionKey(), true));
    }

    @Test
    public void dummyTestForGetValidMenuOption() {
        assertTrue(true);
    }

}