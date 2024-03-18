package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "reservation_id", nullable = false)
    private Integer reservationId;

    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "yoga_session_id", nullable = false)
    private Integer yogaSessionId;

    @Column(name = "retreat_id", nullable = false)
    private Integer retreatId;

    @Column(name = "pending_id", nullable = false)
    private Integer pendingId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

}