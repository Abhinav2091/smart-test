package com.smart.test.dao;

import com.smart.test.model.McqAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface McqAnswerRepo extends JpaRepository<McqAnswer, Long> {
    List<McqAnswer> findAllByQuestionId(Long qId);
}
