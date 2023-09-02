package com.smart.test.dao;

import com.smart.test.model.MockTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockTestRepo extends JpaRepository<MockTest, Long> {
}
