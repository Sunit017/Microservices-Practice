package com.practice.auth_service.service;

import com.practice.auth_service.dto.AuthResponse;
import com.practice.auth_service.dto.LoginRequest;
import com.practice.auth_service.dto.RegisterRequest;
import com.practice.auth_service.entity.Users;
import com.practice.auth_service.exception.UserAlreadyExistsException;
import com.practice.auth_service.repository.UserRepository;
import com.practice.auth_service.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    public AuthResponse register(RegisterRequest registerRequest)
    {
        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent())
        {
            throw new UserAlreadyExistsException("Username already exists: "+registerRequest.getUsername());
        }
        Users users=Users.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(Set.of("ROLE_USER"))
                .enabled(true)
                .build();
        userRepository.save(users);
        UserDetails userDetails= customUserDetailsService.loadUserByUsername(users.getUsername());
        String token =jwtService.generateToken(userDetails);
        return  new AuthResponse(token,null);
    }

    public  AuthResponse login(LoginRequest loginRequest)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );
        UserDetails userDetails= customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token,null);
    }
}
