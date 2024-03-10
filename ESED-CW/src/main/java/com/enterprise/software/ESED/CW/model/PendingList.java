package com.enterprise.software.ESED.CW.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "pending_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PendingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pending_id")
    private Long pendingId;

    @Column(name = "booked_time")
    private Date bookedTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CategoryType type;

    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private enum CategoryType{
        ACTIVITY,WORKSHOP,RETREAT
    }

}
