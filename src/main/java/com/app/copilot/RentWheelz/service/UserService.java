package com.app.copilot.RentWheelz.service;

import com.app.copilot.RentWheelz.dto.UserDto;

import java.util.List;

public interface UserService {

    // this method will create the user in the database and return the user dto
    public UserDto createUser(UserDto userDto);

    // this method will return the user by id
    public UserDto getUser(String email);
    // this method will update the user by id and return the updated user dto
    public UserDto updateUser(String email, UserDto userDto);
    // this method will delete the user by id
    public void deleteUser(String email);
    // this method will return all the users
    public List<UserDto> getAllUsers();


}
