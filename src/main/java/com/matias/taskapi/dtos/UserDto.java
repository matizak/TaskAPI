package com.matias.taskapi.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "Please enter valid name.")
    private String name;

    @NotEmpty(message = "Please enter valid name.")
    private String surname;
    @NotEmpty(message = "Please enter valid name.")
    private String username;

    @NotEmpty(message = "Please enter valid password.")
    private String password;
}
