package com.matias.taskapi.services;

import com.matias.taskapi.dtos.UserDto;
import com.matias.taskapi.entities.Task;
import com.matias.taskapi.entities.User;
import com.matias.taskapi.exceptions.RecordNotFoundException;
import com.matias.taskapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserDto convertToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto taskDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(taskDto, User.class);
    }

    public List<UserDto> getUsers() {
        return this.userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(Long id) {
        return this.convertToDto(userRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("No hay registro con id <" + id + ">")));
    }

    @Override
    public UserDto create(UserDto userDto) {
        return this.convertToDto(userRepository.save(this.convertToEntity(userDto)));
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        userDto.setId(id);
        return this.convertToDto(userRepository.save(convertToEntity(userDto)));
    }

    @Override
    public UserDto delete(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("No hay registro con id <" + id + ">"));
        this.userRepository.delete(user);
        return this.convertToDto(user);
    }

    @Override
    public UserDto login(String username, String password) {
        User user = this.userRepository.findUserByUsernameAndPassword(username,password).orElseThrow(()-> new RecordNotFoundException("Usuario no encontrado"));
        return this.convertToDto(user);
    }
}