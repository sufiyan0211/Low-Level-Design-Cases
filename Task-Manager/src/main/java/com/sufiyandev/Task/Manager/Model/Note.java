package com.sufiyandev.Task.Manager.Model;

import com.fasterxml.jackson.annotation.JsonTypeId;

public class Note {

    private int id;
    private String title;
    private String body;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Note() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
