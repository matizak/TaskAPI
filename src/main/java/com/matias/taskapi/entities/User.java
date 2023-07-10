package com.matias.taskapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }
}