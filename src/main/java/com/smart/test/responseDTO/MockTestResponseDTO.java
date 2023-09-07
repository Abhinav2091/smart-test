package com.smart.test.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MockTestResponseDTO(long id,
                                  String name,
                                  int duration,
                                  @JsonProperty("total_marks")
                                  double totalMarks,
                                  @JsonProperty("min_marks")
                                  double minMarks,
                                  String instruction,
                                  @JsonProperty("result_type")
                                  String resultType) {
}
