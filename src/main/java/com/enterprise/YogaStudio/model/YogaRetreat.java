package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "yoga_retreat")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class YogaRetreat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "retreat_id", nullable = false)
    private Integer id;

    @Column(name = "retreat_name", nullable = false, length = 150)
    private String retreatName;

    @Column(name = "meal", nullable = false, length = 150)
    private String meal;

    @Lob
    @Column(name = "activity_type", nullable = false)
    private String activityType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pricing_id", nullable = false)
    private Pricing pricing;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "yoga_session_id", nullable = false)
    private YogaSession yogaSession;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    // Additional fields for JSON representation
    @Transient
    private Integer instructorId;

    @Transient
    private Integer workshopId;

    @Transient
    private BigDecimal price;

}