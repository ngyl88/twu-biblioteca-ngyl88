package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class MenuHandler {
    private Map<String, String> options = new HashMap<>();

    public Map<String, String> getOptions() {
        return options;
    }

    public String getOptionListAsString() {
        StringBuilder sb = new StringBuilder();
        getOptions().forEach((k, v) -> {
            sb.append(String.format("%3s%s%s", k, " - ", v));
        });
        return sb.toString();
    }

    public MenuHandler() {
        this.options.put("1", "List Books");
    }
}
