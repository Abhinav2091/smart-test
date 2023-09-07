package com.smart.test.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponseDTO<T> {
    private String status;
    private T data;
    private String message;
}
