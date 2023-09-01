package com.smart.test.serviceImpl;

import com.smart.test.requestDTO.AddUserDto;
import com.smart.test.requestDTO.AuthenticationRequest;
import com.smart.test.responseDTO.AuthenticateResponse;
import com.smart.test.service.AuthenticateService;
import com.smart.test.service.JwtService;
import com.smart.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticateResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        var user = userService.getByEmail(request.email()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticateResponse(jwtToken);
    }

    @Override
    public AuthenticateResponse register(AddUserDto request) {
        var user = userService.addUser(request);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticateResponse(jwtToken);
    }
}
