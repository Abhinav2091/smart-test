package com.smart.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity(name = "sub_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, name = "c_name")
    private String name;

    @Column(nullable = false, name = "c_level")
    private int cLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    private MockTest mockTest;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category catId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(nullable = false, name = "updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(nullable = false, name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}