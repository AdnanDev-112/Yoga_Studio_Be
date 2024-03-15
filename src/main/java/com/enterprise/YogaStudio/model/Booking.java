package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Integer bookingid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "yoga_session_id", nullable = false)
    private YogaSession yogaSession;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "retreat_id", nullable = false)
    private YogaRetreat retreat;

    @OneToMany(mappedBy = "booking")
    private Set<Discount> discounts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "booking")
    private Set<Schedule> schedules = new LinkedHashSet<>();

}