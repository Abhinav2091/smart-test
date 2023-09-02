package com.smart.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record QuestionDTO(

        @JsonProperty("q-no") long sNo,
        String question,
        Double marks,
        String type,
        @JsonProperty("subjective-answer")
        String subjectiveAnswer,
        @JsonProperty("mcq-answers")
        List<McqAnswerDTO> mcqAnswers
        ) {
}
