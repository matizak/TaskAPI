package com.matias.taskapi.controllers;

import com.matias.taskapi.dtos.TaskDto;
import com.matias.taskapi.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@ControllerAdvice()
public class TaskControllerImpl implements TaskController{
    private final TaskService taskService;
    @Override
    public List<TaskDto> findAll() throws Exception {
        return taskService.getTasks();
    }

    @Override
    public TaskDto showTask(Long id) throws Exception {
        return taskService.getTask(id);
    }

    @Override
    public ResponseEntity<TaskDto> addTask(TaskDto taskDto) throws Exception {
        return ResponseEntity.ok(taskService.create(taskDto));
    }

    @Override
    public ResponseEntity<TaskDto> deleteTask(Long id) throws Exception {
      return  ResponseEntity.ok(taskService.delete(id));
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(Long id, TaskDto taskDto) throws Exception {
        return ResponseEntity.ok(taskService.update(id,taskDto));
    }
}
