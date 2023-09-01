package com.smart.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "answer")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @OneToOne
    private Question question;

    @Column(nullable = false)
    @JsonProperty("updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(nullable = false)
    @JsonProperty("created_date")
    private LocalDateTime createdDate = LocalDateTime.now();


}
