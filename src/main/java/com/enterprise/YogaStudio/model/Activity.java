package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ACTIVITY")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id", nullable = false)
    private Integer id;

    @Column(name = "activity_type", nullable = false, length = 150)
    private String activityType;

    @Lob
    @Column(name = "level", nullable = false)
    private String level;

    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "recurring", nullable = false)
    private Boolean recurring = false;

}