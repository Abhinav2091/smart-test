package com.smart.test.controller;

import com.smart.test.dao.UserRepo;
import com.smart.test.model.User;
import com.smart.test.requestDTO.AddTestDTO;
import com.smart.test.service.TestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    private final UserRepo userRepo;

    @PostMapping("/add")
    public ResponseEntity<Object> addTest(@Valid @RequestBody AddTestDTO request)
    {
        //TODO validate user from token
        //TODO will return user after validation
        User user=userRepo.findById(1L).get();
        testService.addTest(request,user);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }
}
