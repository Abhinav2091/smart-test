package com.smart.test.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @NotNull(message = "email cannot be blank")
        String email,
        @NotNull(message = "password is required")
        String password) {
}
