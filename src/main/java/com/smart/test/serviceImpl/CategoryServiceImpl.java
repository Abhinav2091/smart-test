package com.smart.test.serviceImpl;

import com.smart.test.dao.CategoryRepo;
import com.smart.test.model.Category;
import com.smart.test.responseDTO.CategoryResponseDTO;
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
        categoryList.add(new Category(5L, "SOFTWARE", 1, LocalDateTime.now(), LocalDateTime.now()));
        categoryList.add(new Category(1L, "GOVT", 1, LocalDateTime.now(), LocalDateTime.now()));
        categoryList.add(new Category(2L, "SALES", 1, LocalDateTime.now(), LocalDateTime.now()));
        categoryList.add(new Category(3L, "MEDICAL", 1, LocalDateTime.now(), LocalDateTime.now()));
        categoryList.add(new Category(4L, "BUSINESS", 1, LocalDateTime.now(), LocalDateTime.now()));
        categoryRepo.saveAll(categoryList);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>(categories.size());
        for (Category category : categories) {
            categoryResponseDTOS.add(new CategoryResponseDTO(category.getId(), category.getCLevel(), category.getCname()));
        }
        return categoryResponseDTOS;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Category not present"));
    }
}
