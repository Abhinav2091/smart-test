package com.smart.test.serviceImpl;

import com.smart.test.dao.QuestionRepo;
import com.smart.test.model.Question;
import com.smart.test.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionTypeServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;

    @Override
    public void addAll(List<Question> questions) {
        questionRepo.saveAll(questions);
    }
}
