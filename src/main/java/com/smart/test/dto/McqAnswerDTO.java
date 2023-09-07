package com.smart.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record McqAnswerDTO(
        @JsonProperty("mcqAnswerValue") boolean value,
        int level,
        @JsonProperty("mcqAnswerLabel")
        String label) {
}
