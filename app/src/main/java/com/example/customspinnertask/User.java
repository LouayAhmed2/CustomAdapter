package com.example.customspinnertask;

public class User implements IDisplay {
    String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return username;
    }
}
