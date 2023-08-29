package com.smart.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.test.enums.QuestionTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("q_no")
    private Long qNo;

    @JsonProperty("q_type")
    private QuestionTypeEnum qType;

    @Column(nullable = false)
    private String content;

    private Double marks;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private MockTest mockTest;

    @OneToOne(mappedBy = "question")
    private Answer answer;

    @Column(nullable = false)
    @JsonProperty("updated_date")
    private LocalDateTime updatedDate=LocalDateTime.now();

    @Column(nullable = false)
    @JsonProperty("created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}
