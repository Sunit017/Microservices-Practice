package com.practice.user_service.controller;

import com.practice.user_service.dto.UserDTO;
import com.practice.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO )
    {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);

    }

    @GetMapping("/all-user")
    public ResponseEntity<List<UserDTO>> getAll()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUserByUserId(id));
    }



}
