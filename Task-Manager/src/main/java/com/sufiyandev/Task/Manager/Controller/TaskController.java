package com.sufiyandev.Task.Manager.Controller;


import com.sufiyandev.Task.Manager.Model.Note;
import com.sufiyandev.Task.Manager.Model.Task;
import com.sufiyandev.Task.Manager.dto.NoteDto;
import com.sufiyandev.Task.Manager.dto.TaskDto;
import com.sufiyandev.Task.Manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    private ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        Task task = taskService.saveTask(taskDto);
        return ResponseEntity.ok(task);
    }

    @GetMapping("")
    private ResponseEntity<List<Task>> listAllTasks() {
        List<Task> allTasks =  taskService.getAllTasks();
        return ResponseEntity.ok(allTasks);
    }


    /***
     * This Api basically use to update Task's following properties
     *  <ul>
     *      <li>Title</li>
     *      <li>Description</li>
     *      <li>Deadline</li>
     *  </ul>
     *  <b>Note that this Api is not use to update the Note of the Task</b>
     *
     * @param id
     * @param taskDto
     * @return Task
     */
    @PutMapping("/{id}")
    private ResponseEntity<Task> editTask(@PathVariable int id, @RequestBody TaskDto taskDto) {
        Task updatedTask = taskService.editTask(id, taskDto);
        if(updatedTask == null || taskDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTask);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    private void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }

    /**
     * API: Fetch all the notes under a particular task
     * @param id
     * @return ResponseEntity<List<Note>>
     */
    @GetMapping("/{id}/notes")
    private ResponseEntity<List<Note>> getNotes(@PathVariable int id) {
        List<Note> allNotes = taskService.getAllNotes(id);
        return ResponseEntity.ok(allNotes);
    }

    /**
     * API: Create a new note under the task with given task id
     * @param id, NoteDto
     * @return ResponseEntity<Task>
     */
    @PostMapping("/{id}/notes")
    private ResponseEntity<Task> addNote(@PathVariable int id, @RequestBody NoteDto noteDto) {
        Task task = taskService.addNote(id, noteDto);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    /**
     * API: Delete a note of a Task
     * @param taskId noteId
     * @return ResponseEntity(String)
     */
    @RequestMapping(value = "/{taskId}/notes/{noteId}", method = RequestMethod.DELETE)
    private ResponseEntity<String> deleteNote(@PathVariable("taskId") int taskId, @PathVariable("noteId") int noteId) {
        if(taskService.deleteNote(taskId, noteId)) {
            return ResponseEntity.ok("Note has been deleted Successfully.");
        }
        return ResponseEntity.unprocessableEntity().body("Task or Note is not found");
    }
}
