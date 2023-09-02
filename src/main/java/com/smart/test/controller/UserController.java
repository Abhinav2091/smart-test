package com.smart.test.controller;

import com.smart.test.requestDTO.AddUserDto;
import com.smart.test.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@Valid @RequestBody AddUserDto request) {
        userService.addUser(request);
        return new ResponseEntity<>(request,HttpStatus.CREATED);
    }
}
