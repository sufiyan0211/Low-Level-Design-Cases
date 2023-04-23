package com.sufiyandev.user;

public class UserBuilder {
    private String name;
    private String username;
    private String userId;
    private Gender gender;
    private Nationality nationality;
    private int age;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public UserBuilder setNationality(Nationality nationality) {
        this.nationality = nationality;
        return this;
    }

    public UserBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public User build() {
        return new User(name, username, userId, gender, nationality, age);
    }
}
