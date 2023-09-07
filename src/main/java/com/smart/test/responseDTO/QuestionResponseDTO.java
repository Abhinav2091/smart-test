package com.smart.test.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.test.dto.McqAnswerDTO;
import com.smart.test.dto.QuestionDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@Getter
@Setter
@ToString
public class QuestionResponseDTO {

    @JsonProperty("questionNo")
    private long sNo;
    private String question;
    private Double marks;
    @JsonProperty("questionType")
    private String type;
    @JsonProperty("subjectiveAnswer")
    private String subjectiveAnswer;
    @JsonProperty("mcqAnswers")
    private List<McqAnswerDTO> mcqAnswers;
}
