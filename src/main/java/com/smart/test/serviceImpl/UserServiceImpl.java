package com.smart.test.serviceImpl;

import com.smart.test.dao.UserRepo;
import com.smart.test.mapper.UserMapper;
import com.smart.test.model.User;
import com.smart.test.requestDTO.AddUserDto;
import com.smart.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepo userRepo;
    @Override
    public void addUser(AddUserDto user) {
        User userModel = userMapper.mapToUser(user);
        userRepo.save(userModel);

    }
}
