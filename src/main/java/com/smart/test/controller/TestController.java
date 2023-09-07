package com.smart.test.controller;

import com.smart.test.dao.UserRepo;
import com.smart.test.dto.ApiResponseDTO;
import com.smart.test.model.User;
import com.smart.test.requestDTO.AddTestDTO;
import com.smart.test.service.TestService;
import com.smart.test.utility.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    private final UserRepo userRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @PostMapping(value = "/add", consumes = "application/json")
    // @CrossOrigin(origins = "*")
    public ResponseEntity<Object> addTest(@Valid @RequestBody AddTestDTO request) {
        //TODO validate user from token
        //TODO will return user after validation
        User user = userRepo.findById(1L).get();
        testService.addTest(request, user);
        return new ResponseEntity<>(new ApiResponseDTO<>(Constants.SUCCESS, null, HttpStatus.CREATED.name()), HttpStatus.CREATED);
    }

    @GetMapping("/details")
    public ResponseEntity<Object> getTestListForUser() {
        //TODO validate user from token
        //TODO will return user after validation
        User user = userRepo.findById(1L).get();
        return new ResponseEntity<>(new ApiResponseDTO<>(Constants.SUCCESS, testService.fetchAllByUser(user), HttpStatus.OK.name()), HttpStatus.OK);
    }

    @GetMapping("/{testId}/detail")
    public ResponseEntity<Object> getTestDetail(@NotNull @PathVariable("testId") Integer testId) {
        User user = userRepo.findById(1L).get();
        LOGGER.debug("getTestDetail {}", testId);
        return new ResponseEntity<>(new ApiResponseDTO<>(Constants.SUCCESS, testService.getTestDetails(user, testId), HttpStatus.OK.name()), HttpStatus.OK);

    }


}
