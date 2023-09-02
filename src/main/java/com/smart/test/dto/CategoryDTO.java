package com.smart.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryDTO(
        long id,
        int level,
        String value) {
}
