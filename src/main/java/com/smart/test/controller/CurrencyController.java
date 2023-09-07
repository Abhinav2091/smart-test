package com.smart.test.controller;

import com.smart.test.dto.ApiResponseDTO;
import com.smart.test.service.CurrencyService;
import com.smart.test.utility.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/all")
    public ResponseEntity<Object> getCategory() {

        return new ResponseEntity<>(new ApiResponseDTO<>(Constants.SUCCESS, currencyService.getAllCurrency(), HttpStatus.OK.name()), HttpStatus.OK);
    }
}
