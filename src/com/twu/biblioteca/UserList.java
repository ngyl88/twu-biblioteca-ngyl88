package com.twu.biblioteca;

import java.util.HashMap;

public class UserList {

    private HashMap<String, User> usersMap = new HashMap<>();

    public UserList() {
        usersMap.put("001-2018", new User("001-2018", "pass1234", "Angela", "angela@example.com", "98887666"));
        usersMap.put("002-2018", new User("002-2018", "pass1234", "Benjamin", "ben@example.com", "91118222"));
        usersMap.put("003-2018", new User("003-2018", "pass1234", "Cecilia", "c@example.com", "81119222"));
    }

    public int getSize() {
        return usersMap.size();
    }

    public boolean checkLoginCredentials(String libraryNumber, String password) {

        if (!usersMap.containsKey(libraryNumber)) {
            return false;
        }

        User retrievedUser = usersMap.get(libraryNumber);
        return retrievedUser.checkPassword(password);

    }

    public User getUserByLibraryNumber(String libraryNumber) {
        return usersMap.get(libraryNumber);
    }
}
