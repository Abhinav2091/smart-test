package com.smart.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record QuestionDTO(

        @JsonProperty("questionNo") long sNo,
        String question,
        Double marks,
        @JsonProperty("questionType")
        String type,
        @JsonProperty("subjectiveAnswer")
        String subjectiveAnswer,
        @JsonProperty("mcqAnswers")
        List<McqAnswerDTO> mcqAnswers
        ) {
}
