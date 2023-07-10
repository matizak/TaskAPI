package com.matias.taskapi.controllers;

import com.matias.taskapi.dtos.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Operaciones de Tareas (Task)")
public interface TaskController {

    @Operation(summary = "Ver todas las tareas")
    @GetMapping("/all")
    List<TaskDto> findAll() throws Exception;

    @Operation(summary = "Obtener una tarea por ID")
    @GetMapping("/{id}")
    TaskDto showTask(@Parameter(description = "Id de la tarea a buscar") @PathVariable("id") Long id) throws Exception;

    @Operation(summary = "Agregar una tarea")
    @PostMapping
    ResponseEntity<TaskDto> addTask(@Valid @RequestBody TaskDto taskDto) throws Exception;

    @Operation(summary = "Borrar una tarea")
    @DeleteMapping("/{id}")
    ResponseEntity<TaskDto> deleteTask(@PathVariable("id") Long id) throws Exception;

    @Operation(summary = "Actualizar una tarea")
    @PutMapping("/{id}")
    ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long id,
                                       @Valid @RequestBody TaskDto captionDto) throws Exception;
}
