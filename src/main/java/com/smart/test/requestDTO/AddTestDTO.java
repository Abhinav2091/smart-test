package com.smart.test.requestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.test.dto.CategoryDTO;
import com.smart.test.dto.McqAnswerDTO;
import com.smart.test.dto.QuestionDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AddTestDTO(
        @NotNull(message = "name of question is required")
        String name,
        int duration,
        @JsonProperty("result-type")
        String resultType,
        @JsonProperty("paid-subscription")
        boolean paidSubscription,
        double amount,
        List<CategoryDTO> categories,
        String instruction,
        List<QuestionDTO> questions,
        int minMarks
) {
}
