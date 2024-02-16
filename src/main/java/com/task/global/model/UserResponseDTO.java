package com.task.global.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private String id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;
    private String message;
}
