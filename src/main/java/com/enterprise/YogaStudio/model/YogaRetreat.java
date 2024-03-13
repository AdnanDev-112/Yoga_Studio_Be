package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "YOGA_RETREAT")
public class YogaRetreat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "retreat_id", nullable = false)
    private Integer id;

    @Column(name = "retreat_name", nullable = false, length = 150)
    private String retreatName;

    @Column(name = "activity_type", nullable = false, length = 150)
    private String activityType;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price", nullable = false, precision = 13, scale = 2)
    private BigDecimal price;

}