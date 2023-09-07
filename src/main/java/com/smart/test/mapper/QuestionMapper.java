package com.smart.test.mapper;

import com.smart.test.dto.QuestionDTO;
import com.smart.test.model.Question;
import com.smart.test.responseDTO.QuestionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionResponseDTO mapToQuestionDTO(Question question);
}
