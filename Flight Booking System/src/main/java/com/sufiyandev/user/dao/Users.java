package com.sufiyandev.user.dao;

import com.sufiyandev.user.User;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public User saveUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> getUsers() {
        return users;
    }
}
