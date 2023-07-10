package com.matias.taskapi.controllers;

import com.matias.taskapi.dtos.LoginDto;
import com.matias.taskapi.dtos.UserDto;
import com.matias.taskapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api/users")
@RequiredArgsConstructor
@ControllerAdvice()
public class UserControllerImpl implements UserController{

    private final UserService userService;
    @Override
    public List<UserDto> findAll() throws Exception {
        return userService.getUsers();
    }

    @Override
    public UserDto showUser(Long id) throws Exception {
        return userService.getUser(id);
    }

    @Override
    public ResponseEntity<UserDto> addUser(UserDto userDto) throws Exception {
        return ResponseEntity.ok(userService.create(userDto));
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long id) throws Exception {
        return  ResponseEntity.ok(userService.delete(id));
    }

    @Override
    public ResponseEntity<UserDto> updateTask(Long id, UserDto userDto) throws Exception {
        return ResponseEntity.ok(userService.update(id,userDto));
    }

    @Override
    public ResponseEntity<UserDto> login(LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto.getUsername(), loginDto.getPassword()));
    }
}
