package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

import static com.twu.biblioteca.DisplayUtils.promptMessage;
import static com.twu.biblioteca.InputUtils.getInputFromUser;

public class MenuHandler {
    private Map<String, MenuOption> options = new HashMap<>();

    public Map<String, MenuOption> getOptions() {
        return options;
    }

    public MenuHandler() {
        for (MenuOption option : MenuOption.values()) {
            this.options.put(option.getOptionKey(), option);
        }
    }

    public String getOptionListAsString(boolean loginStatus) {
        StringBuilder sb = new StringBuilder();
        getOptions().forEach((k, menuOption) -> {
            if (menuOption == MenuOption.VIEW_USER_INFO && !loginStatus) return;

            sb.append(String.format("%3s%s%s", k, " - ", menuOption.getOptionDescription()));
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    private boolean _isOptionNotValid(String userOption) {
        return !getOptions().containsKey(userOption);
    }

    // TODO: UNIT TEST NOT CREATED (support main)
    private boolean _isLoginRequiredForOptionButNotDone(String userOption, boolean loginStatus) {
        boolean notOK = getOptions().get(userOption).isLoginRequired() && !loginStatus;

        if (notOK) {
            promptMessage(MessageHelper.getMessageForLoginRequired());
        }

        return notOK;
    }

    public boolean isValidOptionBasedOnLoginStatus(String userOption, boolean loginStatus) {
        if (_isOptionNotValid(userOption) || _isLoginRequiredForOptionButNotDone(userOption, loginStatus)) {
            return false;
        }
        return true;
    }

    // TODO: UNIT TEST NOT CREATED (support main)
    public String getValidMenuOption(boolean loginStatus) {
        String userOption = getInputFromUser("Please enter your option: ");

        while (!isValidOptionBasedOnLoginStatus(userOption, loginStatus)) {
            promptMessage(MessageHelper.getMessageForInvalidMenuOption());
            userOption = getInputFromUser("Please enter your option: ");
        }
        return userOption;
    }

}
