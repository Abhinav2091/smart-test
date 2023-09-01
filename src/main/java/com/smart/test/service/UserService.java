package com.smart.test.service;

import com.smart.test.model.User;
import com.smart.test.requestDTO.AddUserDto;

import java.util.Optional;

public interface UserService {
    User addUser(AddUserDto user);
    Optional<User> getById(long id);

    Optional<User> getByEmail(String email);
}
