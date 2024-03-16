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
@Table(name = "YOGA_RETREAT")
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
    @Column(name = "ancillary_activity", nullable = false)
    private String ancillaryActivity;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price", nullable = false, precision = 13, scale = 2)
    private BigDecimal price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "yoga_session_id", nullable = false)
    private YogaSession yogaSession;

    @JsonIgnore
    @OneToMany(mappedBy = "retreat", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "retreat", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new LinkedHashSet<>();

}