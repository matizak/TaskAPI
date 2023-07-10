package com.matias.taskapi.entities;

import com.matias.taskapi.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
