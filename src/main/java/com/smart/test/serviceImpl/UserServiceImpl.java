package com.smart.test.serviceImpl;

import com.smart.test.dao.UserRepo;
import com.smart.test.dto.PasswordDto;
import com.smart.test.mapper.UserMapper;
import com.smart.test.model.User;
import com.smart.test.requestDTO.AddUserDto;
import com.smart.test.service.UserService;
import com.smart.test.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder;


    @Override
    public User addUser(AddUserDto user) {
        User userModel = userMapper.mapToUser(user);
        userModel.setPassword(passwordEncoder.encode(user.password()));
        //  PasswordDto passwordDto = Utility.generatePassword(user.password(), Utility.generateRandomNumber.toString());
        // userModel.setPassword(passwordDto.password());
        // userModel.setSalt(passwordDto.salt());
        return userRepo.save(userModel);
    }

    @Override
    public Optional<User> getById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
