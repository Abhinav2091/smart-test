package com.smart.test.model;

import com.smart.test.enums.QuestionTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "question")
@Data
@Getter
@Setter
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "q_no")
    private Long qNo;

    @Column(name = "q_type")
    @Enumerated(EnumType.STRING)
    private QuestionTypeEnum qType;

    @Column(nullable = false, length = 10000)
    private String content;

    private Double marks;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private MockTest mockTest;

    @Column(nullable = false, name = "updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(nullable = false, name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<McqAnswer> mcqAnswerList;

}
