package com.smart.test.service;

import com.smart.test.requestDTO.AddUserDto;
import com.smart.test.requestDTO.AuthenticationRequest;
import com.smart.test.responseDTO.AuthenticateResponse;

public interface AuthenticateService {
    AuthenticateResponse authenticate(AuthenticationRequest request);

    AuthenticateResponse register(AddUserDto request);
}
