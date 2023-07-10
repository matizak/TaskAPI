package com.matias.taskapi.services;

import com.matias.taskapi.dtos.TaskDto;
import com.matias.taskapi.entities.Task;
import com.matias.taskapi.exceptions.RecordNotFoundException;
import com.matias.taskapi.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskDto convertToDto(Task task) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(task, TaskDto.class);
    }

    private Task convertToEntity(TaskDto taskDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(taskDto, Task.class);
    }

    public List<TaskDto> getTasks() {
        return this.taskRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto getTask(Long id) {
        return this.convertToDto(taskRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("No hay registro con id <" + id + ">")));
    }

    @Override
    public TaskDto create(TaskDto taskDto) {
        return this.convertToDto(taskRepository.save(this.convertToEntity(taskDto)));
    }

    @Override
    public TaskDto update(Long id, TaskDto taskDto) {
        taskDto.setId(id);
        return this.convertToDto(taskRepository.save(convertToEntity(taskDto)));
    }

    @Override
    public TaskDto delete(Long id) {
        Task task = this.taskRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("No hay registro con id <" + id + ">"));
        this.taskRepository.delete(task);
        return this.convertToDto(task);
    }
}
