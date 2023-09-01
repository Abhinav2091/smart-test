package com.smart.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "category")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("c_name")
    private String name;

    @Column(nullable = false)
    @JsonProperty("c_level")
    private int cLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    private MockTest mockTest;

    @Column(nullable = false)
    @JsonProperty("updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(nullable = false)
    @JsonProperty("created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}
