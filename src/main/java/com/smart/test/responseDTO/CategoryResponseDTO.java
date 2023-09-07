package com.smart.test.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {
    @JsonProperty("categoryId")
    private long id;
    private int level;
    @JsonProperty("categoryValue")
    private String value;
}
