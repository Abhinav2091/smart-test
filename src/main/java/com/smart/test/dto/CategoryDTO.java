package com.smart.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryDTO(
        @JsonProperty("categoryId")
        long id,
        int level,
        @JsonProperty("categoryValue")
        String value) {
}
