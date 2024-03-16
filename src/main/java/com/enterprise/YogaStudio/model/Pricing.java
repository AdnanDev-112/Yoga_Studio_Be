package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PRICING")
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricing_id", nullable = false)
    private Integer pricingid;

    @Lob
    @Column(name = "type", nullable = false)
    private String pricingtype;

    @Lob
    @Column(name = "level", nullable = false)
    private String level;

    @Column(name = "amount", nullable = false, precision = 13, scale = 2)
    private BigDecimal amount;

}