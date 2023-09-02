package com.smart.test.serviceImpl;

import com.smart.test.dao.CategoryRepo;
import com.smart.test.model.Category;
import com.smart.test.service.CategoryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    //TODO has to remove it later
    @PostConstruct
    public void insertSubcategory() {
        List<Category> categoryList = new ArrayList<>(5);
        categoryList.add(new Category(0L, "SOFTWARE", 0, LocalDateTime.now(), LocalDateTime.now()));
        categoryList.add(new Category(1L, "GOVT", 0, LocalDateTime.now(), LocalDateTime.now()));
        categoryList.add(new Category(2L, "SALES", 0, LocalDateTime.now(), LocalDateTime.now()));
        categoryList.add(new Category(3L, "MEDICAL", 0, LocalDateTime.now(), LocalDateTime.now()));
        categoryList.add(new Category(4L, "BUSINESS", 0, LocalDateTime.now(), LocalDateTime.now()));
        categoryRepo.saveAll(categoryList);
    }

    @Override
    public List<Category> getAllCategories(List<Long> categoryIds) {
        return categoryRepo.findAllById(categoryIds);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Category not present"));
    }
}
