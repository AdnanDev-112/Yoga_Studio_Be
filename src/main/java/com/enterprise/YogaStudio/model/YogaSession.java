package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "recurring", nullable = false)
    private Boolean recurring = false;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pricing_id", nullable = false)
    private Pricing price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    @JsonIgnore
    @OneToMany(mappedBy = "yogaSession", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "yogaSession", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "yogaSession", cascade = CascadeType.ALL)
    private Set<YogaRetreat> yogaRetreats = new LinkedHashSet<>();

}