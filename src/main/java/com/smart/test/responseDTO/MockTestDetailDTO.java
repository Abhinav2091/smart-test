package com.smart.test.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.test.dto.CategoryDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@Getter
@Setter
@ToString
public class MockTestDetailDTO {

    @JsonProperty("testName")
    String name;
    int duration;
    String resultType;
    long currency;
    String currencyName;
    @JsonProperty("isPaid")
    boolean paidSubscription;
    double amount;
    List<CategoryResponseDTO> categories;
    @JsonProperty("instructions")
    String instruction;
    List<QuestionResponseDTO> questions;
    @JsonProperty("passingMarks")
    int minMarks;
}
