package com.smart.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity(name = "mcq_answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class McqAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int level;

    private String value;

    @Column(name = "is_correct")
    private Boolean isCorrect = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
    @Column(nullable = false, name = "updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(nullable = false, name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
}
