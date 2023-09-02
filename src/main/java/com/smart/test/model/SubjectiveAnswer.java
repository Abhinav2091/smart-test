package com.smart.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "subjective_answer")
@Data
public class SubjectiveAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @OneToOne
    private Question question;

    @Column(nullable = false,name = "updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(nullable = false,name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();



}
