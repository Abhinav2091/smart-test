package com.smart.test.serviceImpl;

import com.smart.test.dao.UserRepo;
import com.smart.test.enums.Role;
import com.smart.test.mapper.UserMapper;
import com.smart.test.model.User;
import com.smart.test.requestDTO.AddUserDto;
import com.smart.test.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;

    private final BCryptPasswordEncoder encoder;

    @Override
    public void addUser(AddUserDto user) {
        User userModel = userMapper.mapToUser(user);
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        userRepo.save(userModel);

    }
    //TODO has to remove it later
    @PostConstruct
    public void insert(){
        userRepo.save(new User(1L,"Abhinav","test.abhinav@gmail.com","9876578398","+91","password", LocalDateTime.now(),null,
                true, Role.ADMIN,LocalDateTime.now()));
    }
}
