package com.practice.auth_service.controller;

import com.practice.auth_service.dto.AuthResponse;
import com.practice.auth_service.dto.LoginRequest;
import com.practice.auth_service.dto.RegisterRequest;
import com.practice.auth_service.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest registerRequest)
    {
        AuthResponse response= authService.register(registerRequest);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest loginRequest)
    {
        AuthResponse response= authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }


}
