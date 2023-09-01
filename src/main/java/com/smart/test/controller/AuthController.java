package com.smart.test.controller;

import com.smart.test.requestDTO.AddUserDto;
import com.smart.test.requestDTO.AuthenticationRequest;
import com.smart.test.responseDTO.AuthenticateResponse;
import com.smart.test.service.AuthenticateService;
import com.smart.test.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticateService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> register(@Valid @RequestBody AuthenticationRequest request) {

        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticateResponse> register(@Valid @RequestBody AddUserDto request) {
        return new ResponseEntity<AuthenticateResponse>(authService.register(request), null, HttpStatus.OK);

    }
}
