package com.task.global.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.global.model.UserResponseDTO;
import com.task.global.entity.User;
import com.task.global.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "El API de usuario")

public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    @Operation(summary = "Crear usuario", description = "Crea un nuevo usuario.")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody User user) throws NoSuchAlgorithmException {
        UserResponseDTO registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }
}
