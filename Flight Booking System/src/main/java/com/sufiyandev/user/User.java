package com.sufiyandev.user;

public class User {
    private String name;
    private String username;
    private String userId;
    private Gender gender;
    private Nationality nationality;
    private int age;

    public User(String name, String username, String userId, Gender gender, Nationality nationality, int age) {
        this.name = name;
        this.username = username;
        this.userId = userId;
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
    }

    public User() {
    }
}
