package com.matias.taskapi.controllers;
import com.matias.taskapi.dtos.LoginDto;
import com.matias.taskapi.dtos.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Operaciones de Usuarios (User)")
public interface UserController {

    @Operation(summary = "Ver todos los usuarios")
    @GetMapping("/all")
    List<UserDto> findAll() throws Exception;

    @Operation(summary = "Obtener un usuario por ID")
    @GetMapping("/{id}")
    UserDto showUser(@Parameter(description = "Id de la tarea a buscar") @PathVariable("id") Long id) throws Exception;

    @Operation(summary = "Agregar un usuario")
    @PostMapping
    ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) throws Exception;

    @Operation(summary = "Borrar un usuario")
    @DeleteMapping("/{id}")
    ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id) throws Exception;

    @Operation(summary = "Actualizar un usuario")
    @PutMapping("/{id}")
    ResponseEntity<UserDto> updateTask(@PathVariable("id") Long id,
                                       @Valid @RequestBody UserDto userDto) throws Exception;
    @PostMapping("/login")
    ResponseEntity<UserDto> login(@Valid @RequestBody LoginDto loginDto);
}
