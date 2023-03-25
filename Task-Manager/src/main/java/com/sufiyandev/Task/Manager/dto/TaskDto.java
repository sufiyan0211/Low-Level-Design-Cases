package com.sufiyandev.Task.Manager.dto;

import java.util.List;

public class TaskDto {
    private String title;
    private String description;
    private String deadline;
    private List<NoteDto> notes;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public List<NoteDto> getNotes() {
        return notes;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }
}
