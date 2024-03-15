package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer id;

    @Column(name = "client_name", nullable = false, length = 150)
    private String clientName;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "client_discount_status", nullable = false)
    private Boolean clientDiscountStatus = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    @OneToMany(mappedBy = "client")
    private Set<Booking> bookings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<PendingList> pendingLists = new LinkedHashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<WaitingList> waitingLists = new LinkedHashSet<>();

}