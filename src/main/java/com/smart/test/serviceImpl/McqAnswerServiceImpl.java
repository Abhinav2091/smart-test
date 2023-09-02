package com.smart.test.serviceImpl;

import com.smart.test.dao.McqAnswerRepo;
import com.smart.test.model.McqAnswer;
import com.smart.test.service.McqAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class McqAnswerServiceImpl implements McqAnswerService {

    private final McqAnswerRepo mcqAnswerRepo;

    @Override
    public void addAll(List<McqAnswer> mcqAnswerList) {
        mcqAnswerRepo.saveAll(mcqAnswerList);
    }
}
