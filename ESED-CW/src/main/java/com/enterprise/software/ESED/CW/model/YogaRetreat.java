package com.enterprise.software.ESED.CW.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "waiting_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YogaRetreat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "retreat_id")
    private Long retreatId;

    @Column(name = "retreat_name", nullable = false, length = 150)
    private String retreatName;

    @Column(name = "activity_type", nullable = false, length = 150)
    private String activityType;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "pricing_id", nullable = false)
    private Pricing pricing;

}
