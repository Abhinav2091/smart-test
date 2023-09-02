package com.smart.test.serviceImpl;

import com.smart.test.dao.SubCategoryRepo;
import com.smart.test.model.SubCategory;
import com.smart.test.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepo subCategoryRepo;

    @Override
    public void addAll(List<SubCategory> subCategoryList) {
        subCategoryRepo.saveAll(subCategoryList);
    }
}
