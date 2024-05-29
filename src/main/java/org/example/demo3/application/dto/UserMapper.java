package org.example.demo3.application.dto;

import org.example.demo3.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Convert from User domain model to UserDTO
    public static UserDTO userToUserDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAge(user.getAge());
        dto.setDateOfBirth(user.getDateOfBirth());
        return dto;
    }

    // Convert from UserDTO to User domain model
    public static User userDTOToUser(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setDateOfBirth(dto.getDateOfBirth());
        return user;
    }
}

