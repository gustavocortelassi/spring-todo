package com.SpringMessage.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SpringMessage.message.model.TaskModel;
import com.SpringMessage.message.repository.TaskRepository;


@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long>{
    
}
