package com.app.copilot.RentWheelz.service.impl;

import com.app.copilot.RentWheelz.dto.UserDto;
import com.app.copilot.RentWheelz.entity.User;
import com.app.copilot.RentWheelz.exception.UserNotFoundException;
import com.app.copilot.RentWheelz.repository.UserRepository;
import com.app.copilot.RentWheelz.service.UserService;
// this is service layer of user
// it should implement all the methods of user service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // this method will create the user in the database and return the user dto

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }

    @Override
    public UserDto getUser(String email) {
        User user = userRepository.findById(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        return convertToDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        User user = userRepository.findById(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        // Update user details here
        user.setUserName(userDto.getUserName());
        user.setUserPassword(userDto.getUserPassword());
        user.setProofId(userDto.getProofId());
        User updatedUser = userRepository.save(user);
        return convertToDto(updatedUser);
    }

    @Override
    public void deleteUser(String email) {
        if (!userRepository.existsById(email)) {
            throw new UserNotFoundException("User not found with email: " + email);
        }
        userRepository.deleteById(email);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserEmail(user.getUserEmail());
        userDto.setUserName(user.getUserName());
        userDto.setUserPassword(user.getUserPassword());
        userDto.setProofId(user.getProofId());
        return userDto;
    }

    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setUserEmail(userDto.getUserEmail());
        user.setUserName(userDto.getUserName());
        user.setUserPassword(userDto.getUserPassword());
        user.setProofId(userDto.getProofId());
        return user;
    }
}
