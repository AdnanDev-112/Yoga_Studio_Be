package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Integer bookingid;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "schedule_id", nullable = false)
 private Schedule schedule;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discount_id", nullable = false)
    private Discount discount;

}