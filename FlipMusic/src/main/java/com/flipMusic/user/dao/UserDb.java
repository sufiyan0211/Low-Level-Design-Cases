package com.flipMusic.user.dao;

import com.flipMusic.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class
 */
public class UserDb {
    private List<User> users;
    private static boolean initialized = false;
    private static UserDb userDb;

    private UserDb() {
        users = new ArrayList<>();
    }

    public static UserDb getInstance() {
        if(initialized == true) return userDb;
        initialized = true;
        userDb = new UserDb();
        return userDb;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUserByName(String name) {
        for(User user: users) {
            if(user.getName() == name) {
                return user;
            }
        }
        return null;
    }
}
