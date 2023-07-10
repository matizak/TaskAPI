package com.matias.taskapi.services;

import com.matias.taskapi.dtos.TaskDto;
import com.matias.taskapi.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    UserDto getUser(Long id);

    UserDto create(UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    UserDto delete(Long id);

    UserDto login(String username, String password);
}
