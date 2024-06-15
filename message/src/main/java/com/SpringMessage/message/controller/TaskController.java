package com.SpringMessage.message.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMessage.message.model.TaskModel;
import com.SpringMessage.message.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    // listar tasks
    @GetMapping
    public List<TaskModel> getAllTask() {
        return taskService.getAllTask();
    }

    // criar tasks
    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task){
        return taskService.saveTask(task);
    }

    // atualizar tasks
    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> updateTaskById(@PathVariable Long id, @RequestBody TaskModel taskDetails) {
        TaskModel updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    // deletar tasks
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTasksById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

}
