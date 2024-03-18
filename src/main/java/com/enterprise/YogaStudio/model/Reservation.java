package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reservation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "category_type", nullable = false)
    private String categoryType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "yoga_session_id")
    private YogaSession yogaSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "retreat_id")
    private YogaRetreat retreat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pending_id", nullable = false)
    private PendingList pending;

}