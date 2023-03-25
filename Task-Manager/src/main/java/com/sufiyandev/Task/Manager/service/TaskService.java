package com.sufiyandev.Task.Manager.service;

import com.sufiyandev.Task.Manager.Model.Note;
import com.sufiyandev.Task.Manager.Model.Task;
import com.sufiyandev.Task.Manager.dto.NoteDto;
import com.sufiyandev.Task.Manager.dto.TaskDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class TaskService {
    private List<Task> tasksList;
    private static int taskId = 1;
    private static int noteId = 1;

    Logger logger = LoggerFactory.getLogger(TaskService.class);

    public TaskService() {
        tasksList = new LinkedList<>();
    }

    public Task saveTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(this.taskId++);
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());

        DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
        try {
            Date deadline = dateFormat.parse(taskDto.getDeadline());
            task.setDeadline(deadline);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(taskDto != null && !taskDto.getNotes().isEmpty()) {
            List<Note> notes = new ArrayList<>();
            for(NoteDto noteDto: taskDto.getNotes()) {
                Note note = new Note();
                note.setId(this.noteId++);
                note.setTitle(noteDto.getTitle());
                note.setBody(noteDto.getBody());
                notes.add(note);
            }
            task.setNotes(notes);
        }
        task.setStatus(false); // when new task is created then initial status would be false;
        tasksList.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return tasksList;
    }

    public Task editTask(int taskId, TaskDto taskDto) {
        Task updateTask = findTask(taskId);

        if(updateTask == null) {
            String warningMsg = String.format("Can't be update the task because the taskId " + taskId  + " was not present");
            logger.warn(warningMsg);
            return updateTask;
        }

        if(taskDto.getTitle() != null && !taskDto.getTitle().isEmpty()) {
            updateTask.setTitle(taskDto.getTitle());
        }

        if(taskDto.getDescription() != null && !taskDto.getDescription().isEmpty()) {
            updateTask.setTitle(taskDto.getDescription());
        }

        if(taskDto.getDeadline() != null && !taskDto.getDeadline().isEmpty()) {
            DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
            try {
                Date deadline = dateFormat.parse(taskDto.getDeadline());
                updateTask.setDeadline(deadline);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        if (taskDto.getStatus() != null) {
            updateTask.setStatus(taskDto.getStatus());
        }

        return updateTask;
    }

    public void deleteTask(int id) {
        Task targetTask = null;
        for(Task task: tasksList) {
            if(task.getId() == id) {
                targetTask = task;
                break;
            }
        }
        if(targetTask == null) {
            logger.warn("Target Can't be deleted because id is not found in the TaskList");
            return;
        }
        tasksList.remove(targetTask);
    }

    public List<Note> getAllNotes(int taskId) {
        Task targetTask = findTask(taskId);
        if(targetTask == null) {
            logger.warn("Task of given task id does not exist");
            return new LinkedList<>();
        }
        return targetTask.getNotes();
    }

    private Task findTask(int taskId) {
        for(Task task : tasksList) {
            if(task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public Task addNote(int taskId, NoteDto noteDto) {
        Task task = findTask(taskId);
        if(task == null) {
            return null;
        }

        Note note = new Note();
        note.setId(this.noteId++);
        note.setTitle(noteDto.getTitle());
        note.setBody(noteDto.getBody());
        List<Note> notes = task.getNotes();
        notes.add(note);
        return task;
    }

    public boolean deleteNote(int taskId, int noteId) {
        Task task = findTask(taskId);
        if(task == null) return false;
        Note note = findNote(task, noteId);
        if(note == null) return false;
        List<Note> notes = task.getNotes();
        notes.remove(note);
        task.setNotes(notes);
        return true;
    }

    private Note findNote(Task task, int noteId) {
        for(Note note: task.getNotes()) {
            if(note.getId() == noteId) {
                return note;
            }
        }
        return null;
    }


}
