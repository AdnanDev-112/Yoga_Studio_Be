package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Integer courseid;

    @Column(name = "course_name", nullable = false, length = 150)
    private String courseName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "number_of_classes", nullable = false)
    private Integer numberOfClasses;

    @Column(name = "price", nullable = false, precision = 13, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studio_id", nullable = false)
    @JsonIgnore
    private Studio studio;

    @OneToMany(mappedBy = "course" , cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pricing_id", nullable = false)
    @JsonIgnore
    private Pricing pricing;

}