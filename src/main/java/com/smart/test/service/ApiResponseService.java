package com.smart.test.service;

import com.smart.test.dto.ApiResponseDTO;

public interface ApiResponseService {

    ApiResponseDTO<Object> success();

    ApiResponseDTO<Object> failure();
}
