package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pending_list")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PendingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pending_id", nullable = false)
    private Integer id;

    @Column(name = "booked_time")
    private LocalDateTime bookedTime;

    @Column(name = "confirmed_status")
    private Boolean confirmedStatus;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

}