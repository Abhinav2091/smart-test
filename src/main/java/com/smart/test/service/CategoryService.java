package com.smart.test.service;

import com.smart.test.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories(List<Long> categoryIds);
    Category getById(Long id);
}
