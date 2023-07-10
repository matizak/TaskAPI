package com.matias.taskapi.services;

import com.matias.taskapi.dtos.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTasks();

    TaskDto getTask(Long id);

    TaskDto create(TaskDto userDto);

    TaskDto update(Long id, TaskDto userDto);

    TaskDto delete(Long id);
}
