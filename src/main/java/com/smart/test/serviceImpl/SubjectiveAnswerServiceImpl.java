package com.smart.test.serviceImpl;

import com.smart.test.dao.SubjectiveAnswerRepo;
import com.smart.test.model.SubjectiveAnswer;
import com.smart.test.service.SubjectiveAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectiveAnswerServiceImpl implements SubjectiveAnswerService {
    private final SubjectiveAnswerRepo subjectiveAnswerRepo;
    @Override
    public void addAll(List<SubjectiveAnswer> subjectiveAnswerList) {
        subjectiveAnswerRepo.saveAll(subjectiveAnswerList);
    }

    @Override
    public SubjectiveAnswer getByQuestionID(Long qId) {
        return subjectiveAnswerRepo.findByQuestionId(qId);
    }
}
