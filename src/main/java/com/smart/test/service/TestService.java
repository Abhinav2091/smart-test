package com.smart.test.service;

import com.smart.test.model.User;
import com.smart.test.requestDTO.AddTestDTO;
import com.smart.test.responseDTO.MockTestDetailDTO;
import com.smart.test.responseDTO.MockTestResponseDTO;

import java.util.List;

public interface TestService {
    void addTest(AddTestDTO request, User user);

    List<MockTestResponseDTO> fetchAllByUser(User user);

    MockTestDetailDTO getTestDetails(User user, Integer testId);
}
