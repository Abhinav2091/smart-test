package com.smart.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "user_details")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 20)
    private String number;

    @Column(nullable = false, length = 5)
    @JsonProperty("country_code")
    private String countryCode;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @JsonProperty("created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @OneToMany(mappedBy = "user")
    private List<MockTest> mockTest;

    private Boolean status = true;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();


}
