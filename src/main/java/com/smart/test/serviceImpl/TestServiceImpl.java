package com.smart.test.serviceImpl;

import com.smart.test.dao.CurrencyRepo;
import com.smart.test.dao.MockTestRepo;
import com.smart.test.dto.CategoryDTO;
import com.smart.test.dto.McqAnswerDTO;
import com.smart.test.dto.QuestionDTO;
import com.smart.test.enums.QuestionTypeEnum;
import com.smart.test.enums.SubscriptionTypeEnum;
import com.smart.test.mapper.McqAnswerMapper;
import com.smart.test.mapper.QuestionMapper;
import com.smart.test.mapper.TestMapper;
import com.smart.test.model.*;
import com.smart.test.requestDTO.AddTestDTO;
import com.smart.test.responseDTO.CategoryResponseDTO;
import com.smart.test.responseDTO.MockTestDetailDTO;
import com.smart.test.responseDTO.MockTestResponseDTO;
import com.smart.test.responseDTO.QuestionResponseDTO;
import com.smart.test.service.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
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

    private final CurrencyRepo currencyRepo;

    private final QuestionMapper questionMapper;


    @Override

    public void addTest(AddTestDTO request, User user) {

        LOGGER.debug("val: {}", request);
        MockTest mockTest = testMapper.mapToMockTest(request);
        LOGGER.debug("val: {}", mockTest);
        mockTest.setUser(user);
        SubscriptionTypeEnum subType = request.paidSubscription() ? SubscriptionTypeEnum.PAID : SubscriptionTypeEnum.FREE;
        mockTest.setSubType(subType);
        Category category = null;
        Currency currency = null;
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
        mockTest.setCurrency(currencyRepo.findById((long) request.currency()).orElseThrow(() -> new NoSuchElementException("Currency not available")));
        testRepo.save(mockTest);
        for (CategoryDTO categoryDTO : request.categories()) {
            if (categoryDTO.id() > 0) {
                category = categoryService.getById(categoryDTO.id());
                LOGGER.debug("inside if category fetched while adding {}",category);
            } else {
                LOGGER.debug("inside else category fetched while adding {}",category);
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
            } else {

                for (McqAnswerDTO mcqAnswerDTO : questionDTO.mcqAnswers()) {
                    mcqAnswer = mcqAnswerMapper.mapToMcqAnswer(mcqAnswerDTO);
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

    @Override
    public List<MockTestResponseDTO> fetchAllByUser(User user) {
        user.getMockTest().sort(Comparator.comparing(MockTest::getCreatedDate).reversed());
        return testMapper.mapToMockTestResponseDTO(user.getMockTest());
    }

    @Override
    public MockTestDetailDTO getTestDetails(User user, Integer testId) {

        MockTest mockTest = testRepo.findByUserIdAndId(user.getId(), testId);
        LOGGER.debug("getTestDetails {}", mockTest.getId());
        MockTestDetailDTO resultDTO = testMapper.mapToMockTestDetailDTO(mockTest);
        resultDTO.setPaidSubscription(mockTest.getSubType().equals(SubscriptionTypeEnum.PAID));
        List<QuestionResponseDTO> questionResponseDTOS = new ArrayList<>();
        QuestionResponseDTO questionResponseDTO = null;
        setQuestionResponseDTO(mockTest, questionResponseDTOS);
        resultDTO.setQuestions(questionResponseDTOS);
        resultDTO.setCurrency(mockTest.getCurrency().getId());
        resultDTO.setCurrencyName(mockTest.getCurrency().getName());
        LOGGER.debug("getTestDetails currency {}", mockTest.getCurrency());


        List<SubCategory> subCategoryList = mockTest.getCatIds();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>(subCategoryList.size());
      //  Category category = subCategoryList.get(0).getCatId();
      //  categoryResponseDTOS.add(new CategoryResponseDTO(category.getId(), category.getCLevel(), category.getCname()));
        for (SubCategory subCategory : subCategoryList) {
            categoryResponseDTOS.add(new CategoryResponseDTO(subCategory.getId(), subCategory.getCLevel(), subCategory.getName()));
            LOGGER.debug("subCategoryList {} {}", subCategory.getId(), subCategory.getCLevel());
           // LOGGER.debug("main cat id {} {} {}", subCategory.getCatId().getId(), subCategory.getCatId().getCname(), subCategory.getCatId().getCLevel());
        }
        categoryResponseDTOS.sort(Comparator.comparing(CategoryResponseDTO::getLevel));
        resultDTO.setCategories(categoryResponseDTOS);

        return resultDTO;
    }

    private void setQuestionResponseDTO(MockTest mockTest, List<QuestionResponseDTO> questionResponseDTOS) {
        QuestionResponseDTO questionResponseDTO;
        for (Question question : mockTest.getQuestionList()) {
            questionResponseDTO = new QuestionResponseDTO();
            questionResponseDTO.setSNo(question.getQNo());
            questionResponseDTO.setMarks(question.getMarks());
            questionResponseDTO.setQuestion(question.getContent());
            //need to check for type to fetch the question answer
            questionResponseDTO.setType(question.getQType().toString());
            if (question.getQType().toString().equals("MCQ")) {
                List<McqAnswer> mcqAnswers = mcqAnswerService.getAllByQuestionId(question.getId());
                List<McqAnswerDTO> resultMCQAnswer = new ArrayList<>(mcqAnswers.size());
                for (McqAnswer mcqAnswer : mcqAnswers) {
                    resultMCQAnswer.add(new McqAnswerDTO(mcqAnswer.getIsCorrect(), mcqAnswer.getLevel(), mcqAnswer.getValue()));
                }
                mcqAnswers.sort(Comparator.comparing(McqAnswer::getLevel));
                questionResponseDTO.setMcqAnswers(resultMCQAnswer);

            } else {
                SubjectiveAnswer subjectiveAnswer = subjectiveAnswerService.getByQuestionID(question.getId());
                questionResponseDTO.setSubjectiveAnswer(subjectiveAnswer.getContent());
            }
            questionResponseDTOS.add(questionResponseDTO);
        }
    }


}
