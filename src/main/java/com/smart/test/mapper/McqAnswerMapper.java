package com.smart.test.mapper;

import com.smart.test.dto.McqAnswerDTO;
import com.smart.test.model.McqAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface McqAnswerMapper {

    @Mapping(source = "value", target = "isCorrect")
    @Mapping(source = "label", target = "value")
    McqAnswer mapToMcqAnswer(McqAnswerDTO mcqAnswerDTO);
}
