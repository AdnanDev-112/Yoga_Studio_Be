package com.enterprise.YogaStudio.model;

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
@Table(name = "YOGA_SESSION")
public class YogaSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yoga_session_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "activity_type")
    private String activityType;

    @Lob
    @Column(name = "level")
    private String level;

    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;

    @Column(name = "price", nullable = false, precision = 13, scale = 2)
    private BigDecimal price;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "recurring", nullable = false)
    private Boolean recurring = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    @OneToMany(mappedBy = "yogaSession")
    private Set<Booking> bookings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "yogaSession")
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "yogaSession")
    private Set<YogaRetreat> yogaRetreats = new LinkedHashSet<>();

}