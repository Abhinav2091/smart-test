package com.smart.test.service;

import com.smart.test.model.Category;
import com.smart.test.responseDTO.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryResponseDTO> getAllCategories();
    Category getById(Long id);
}
