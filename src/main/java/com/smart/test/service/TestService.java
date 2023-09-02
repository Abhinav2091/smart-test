package com.smart.test.service;

import com.smart.test.model.User;
import com.smart.test.requestDTO.AddTestDTO;

public interface TestService {
    void addTest(AddTestDTO request, User user);
}
