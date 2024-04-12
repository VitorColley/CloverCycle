package com.example.clovercycle;

public class UsersManaging {
    private static UsersManaging instance;
    private String loggedInUsername;

    private void UserManager() {
        // Private constructor to prevent instantiation
    }


    public static synchronized UsersManaging getInstance() {
        if (instance == null) {
            instance = new UsersManaging();
        }
        return instance;
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public void setLoggedInUsername(String username) {
        loggedInUsername= username;
    }
}