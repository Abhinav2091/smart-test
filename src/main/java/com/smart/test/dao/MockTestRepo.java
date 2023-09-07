package com.smart.test.dao;

import com.smart.test.model.MockTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockTestRepo extends JpaRepository<MockTest, Long> {
    List<MockTest> findByUserId(long userId);

    MockTest findByUserIdAndId(Long id, Integer testId);
}
