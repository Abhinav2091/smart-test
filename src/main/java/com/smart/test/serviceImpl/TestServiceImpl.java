package com.smart.test.serviceImpl;

import com.smart.test.dao.CategoryRepo;
import com.smart.test.dao.MockTestRepo;
import com.smart.test.dto.CategoryDTO;
import com.smart.test.dto.McqAnswerDTO;
import com.smart.test.dto.QuestionDTO;
import com.smart.test.enums.QuestionTypeEnum;
import com.smart.test.enums.SubscriptionTypeEnum;
import com.smart.test.mapper.McqAnswerMapper;
import com.smart.test.mapper.TestMapper;
import com.smart.test.model.*;
import com.smart.test.requestDTO.AddTestDTO;
import com.smart.test.service.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);
    private final TestMapper testMapper;

    private final McqAnswerMapper mcqAnswerMapper;

    private final MockTestRepo testRepo;

    private final CategoryService categoryService;

    private final SubCategoryService subCategoryService;

    private final QuestionService questionService;

    private final McqAnswerService mcqAnswerService;

    private final SubjectiveAnswerService subjectiveAnswerService;


    @Override

    public void addTest(AddTestDTO request, User user) {

        LOGGER.info("val: {}", request);
        MockTest mockTest = testMapper.mapToMockTest(request);
        LOGGER.info("val: {}", mockTest);
        mockTest.setUser(user);
        SubscriptionTypeEnum subType = request.paidSubscription() ? SubscriptionTypeEnum.PAID : SubscriptionTypeEnum.FREE;
        mockTest.setSubType(subType);
        Category category = null;
        QuestionTypeEnum questionType = null;
        SubCategory subCategory = null;
        Question question = null;
        McqAnswer mcqAnswer = null;
        SubjectiveAnswer subjectiveAnswer = null;
        List<SubCategory> subCategoryList = new ArrayList<>();
        List<Question> questionList = new ArrayList<>();
        List<McqAnswer> mcqAnswerList = new ArrayList<>();
        List<SubjectiveAnswer> subjectiveAnswerList = new ArrayList<>();
        if (subType.equals(SubscriptionTypeEnum.PAID))
            mockTest.setAmount(request.amount());

        mockTest.setTotalMarks(request.questions().stream().mapToDouble(QuestionDTO::marks).sum());
        testRepo.save(mockTest);
        for (CategoryDTO categoryDTO : request.categories()) {
            if (categoryDTO.id() > 0) {
                category = categoryService.getById(categoryDTO.id());
            } else {
                subCategory = new SubCategory();
                subCategory.setCatId(category);
                subCategory.setCLevel(categoryDTO.level());
                subCategory.setMockTest(mockTest);
                subCategory.setUserId(user);
                subCategory.setName(categoryDTO.value());
                subCategoryList.add(subCategory);
            }
        }
        for (QuestionDTO questionDTO : request.questions()) {
            questionType = questionDTO.type().equals("subjective") ? QuestionTypeEnum.SUB : QuestionTypeEnum.MCQ;
            question = new Question();
            question.setMockTest(mockTest);
            question.setMarks(questionDTO.marks());
            question.setQNo(questionDTO.sNo());
            question.setContent(questionDTO.question());
            question.setQType(questionType);
            questionList.add(question);
            if (questionType.equals(QuestionTypeEnum.SUB)) {
                subjectiveAnswer = new SubjectiveAnswer();
                subjectiveAnswer.setContent(questionDTO.subjectiveAnswer());
                subjectiveAnswer.setQuestion(question);
                subjectiveAnswerList.add(subjectiveAnswer);
            } else if (questionType.equals(QuestionTypeEnum.MCQ)) {

                for (McqAnswerDTO mcqAnswerDTO : questionDTO.mcqAnswers()) {
                    mcqAnswer=mcqAnswerMapper.mapToMcqAnswer(mcqAnswerDTO);
                    mcqAnswer.setQuestion(question);
                    mcqAnswerList.add(mcqAnswer);
                }
            }
        }

        questionService.addAll(questionList);
        subCategoryService.addAll(subCategoryList);
        mcqAnswerService.addAll(mcqAnswerList);
        subjectiveAnswerService.addAll(subjectiveAnswerList);


    }

}
