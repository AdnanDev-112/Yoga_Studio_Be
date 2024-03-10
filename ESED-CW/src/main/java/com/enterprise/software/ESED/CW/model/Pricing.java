package com.enterprise.software.ESED.CW.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "pricing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricing_id")
    private Long pricingId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CategoryType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private Level level;

    @Column(name = "amount", nullable = false, precision = 13, scale = 2)
    private Double amount;

    private enum CategoryType{
        ACTIVITY,WORKSHOP,RETREAT
    }

    private enum Level{
        BEGINNER,INTERIM,ADVANCED
    }

}
