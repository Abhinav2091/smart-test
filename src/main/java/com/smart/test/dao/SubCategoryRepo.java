package com.smart.test.dao;

import com.smart.test.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepo extends JpaRepository<SubCategory,Long> {
}
