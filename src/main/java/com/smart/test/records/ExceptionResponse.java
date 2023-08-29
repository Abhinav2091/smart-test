package com.smart.test.records;

import java.time.LocalDate;

public record ExceptionResponse(LocalDate timestamp,
        String message,
        String details) {
}
