package com.smart.test.mapper;

import com.smart.test.dto.McqAnswerDTO;
import com.smart.test.model.McqAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface McqAnswerMapper {

    @Mapping(source = "value", target = "isCorrect")
    @Mapping(source = "label", target = "value")
    McqAnswer mapToMcqAnswer(McqAnswerDTO mcqAnswerDTO);

    @Mapping(source = "isCorrect", target = "value")
    @Mapping(source = "value", target = "label")
    List<McqAnswerDTO> mapToMcqAnswerDTO(List<McqAnswer> mcqAnswers);
}
