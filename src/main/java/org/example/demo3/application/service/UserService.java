package org.example.demo3.application.service;

import org.example.demo3.application.dto.UserDTO;
import org.example.demo3.application.dto.UserMapper;
import org.example.demo3.application.exception.ResourceNotFoundException;
import org.example.demo3.domain.User;
import org.example.demo3.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
         return Optional.of(userRepository.findAll()).orElse(new ArrayList<>())
                 .stream()
                 .map(UserMapper::userToUserDTO)
                 .toList();
    }

    public UserDTO addUser(UserDTO userDTO) {
        // Convert UserDTO to User entity
        User user = UserMapper.userDTOToUser(userDTO);
        // Save the User entity
        User savedUser = userRepository.save(user);
        // Convert the saved User entity back to UserDTO
        return UserMapper.userToUserDTO(savedUser);
    }


    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // Convert UserDTO to User entity
        User user = UserMapper.userDTOToUser(userDTO);
        // Set the ID of the user to the provided ID
        user.setId(id);
        // Save the updated user entity
        User updatedUser = userRepository.save(user);
        // Convert the saved user entity back to UserDTO
        return UserMapper.userToUserDTO(updatedUser);
    }

    public UserDTO deleteUser(Long id) {
        // Fetch the user for returning UserDTO if needed
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.deleteById(id);
        return UserMapper.userToUserDTO(user); // Return UserDTO of the deleted user
    }
}
