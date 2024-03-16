package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "yoga_session_id", nullable = false)
    private YogaSession yogaSession;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "retreat_id", nullable = false)
    private YogaRetreat retreat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Lob
    @Column(name = "category_type", nullable = false)
    private String categoryType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discount_id", nullable = false)
    private Discount discount;

}