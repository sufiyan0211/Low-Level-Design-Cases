package com.sufiyandev.Task.Manager.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Task {

    private int id;
    private String title;
    private String description;
    private Date deadline;
    private List<Note> notes;
    private boolean status;

    public Task() {
        this.notes = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public boolean getStatus() {
        return status;
    }
}
