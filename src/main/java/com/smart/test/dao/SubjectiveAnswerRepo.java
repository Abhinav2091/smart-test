package com.smart.test.dao;

import com.smart.test.model.SubjectiveAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectiveAnswerRepo extends JpaRepository<SubjectiveAnswer, Long> {
}
