package com.smart.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.test.enums.SubscriptionTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "mock_test")
@Data
public class MockTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "mockTest")
    private List<Category> catIds;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private LocalTime duration;

    @JsonProperty("total_marks")
    private Double totalMarks;

    @JsonProperty("min_marks")
    private Double minMarks;

    @JsonProperty("sub_type")
    private SubscriptionTypeEnum subType;

    private Double amount;

    private String instruction;

    @JsonProperty("result_type")

    private String resultType;

    @OneToMany(mappedBy = "mockTest", fetch = FetchType.LAZY)
    private List<Question> questionList;

    @Column(nullable = false)
    @JsonProperty("updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();
    ;


}
