package com.smart.test.model;

import com.smart.test.enums.SubscriptionTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "mock_test")
@Data
public class MockTest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "mockTest")
    private List<SubCategory> catIds;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private int duration;

    @Column(name = "total_marks")
    private Double totalMarks;

    @Column(name = "min_marks")
    private Double minMarks;

    @Column(name = "subscription_type")
    @Enumerated(EnumType.STRING)
    private SubscriptionTypeEnum subType;

    private Double amount;

    private String instruction;

    @Column(name = "result_type")
    private String resultType;

    @OneToMany(mappedBy = "mockTest", fetch = FetchType.LAZY)
    private List<Question> questionList;

    @Column(nullable = false,name = "updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(nullable = false,name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency-id")
    private Currency currency;


}
