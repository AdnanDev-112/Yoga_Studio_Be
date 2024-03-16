package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PENDING_LIST")
public class PendingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pending_id", nullable = false)
    private Integer id;


    @Column(name = "booked_time")
    private LocalDate bookedTime;

    @Lob
    @Column(name = "category_type", nullable = false)
    private String categoryType;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}