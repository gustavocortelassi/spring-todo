package com.SpringMessage.message.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringMessage.message.model.TaskModel;
import com.SpringMessage.message.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;  

    public List<TaskModel> getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<TaskModel> getAllTaskById(Long id){
        return taskRepository.findById(id);
    }

    public TaskModel saveTask(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }

    public TaskModel updateTask(Long id, TaskModel taskDetails){
        TaskModel task = new TaskModel();

        task.setDescricao(taskDetails.getDescricao());
        task.setDataCriacao(taskDetails.getDataCriacao());
        task.setDataConclusao(taskDetails.getDataConclusao());
        task.setStatus(taskDetails.getStatus());

        return taskRepository.save(task);
    }
}
