package com.smart.test.requestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddUserDto(
        @NotBlank(message = "name is required")
        String name,
        @Email(message = "email is not valid")
        String email,
        @NotBlank(message = "number is required")
        @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number format")
        String number,
        @NotBlank(message = "country code is required")
        @JsonProperty("country_code")
        String countryCode,
        @NotBlank(message = "password is required")
        String password) {


}