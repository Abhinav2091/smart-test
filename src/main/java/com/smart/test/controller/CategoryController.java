package com.smart.test.controller;

import com.smart.test.dto.ApiResponseDTO;
import com.smart.test.service.CategoryService;
import com.smart.test.utility.Constants;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<Object> getCategory() {

        return new ResponseEntity<>(new ApiResponseDTO<>(Constants.SUCCESS, categoryService.getAllCategories(), HttpStatus.OK.name()), HttpStatus.OK);
    }
}
