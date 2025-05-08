package com.practice.user_service.service;

import com.practice.user_service.dto.UserDTO;
import com.practice.user_service.entity.User;
import com.practice.user_service.exception.ResourceNotFoundException;
import com.practice.user_service.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO createUser(UserDTO userDTO)
    {

        User user=modelMapper.map(userDTO, User.class);
        User savedUser=userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public List<UserDTO> getAllUsers()
    {
        List<User> users=userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    public UserDTO getUserByUserId(Long userId)
    {
        User user=userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return modelMapper.map(user, UserDTO.class);
    }

}
