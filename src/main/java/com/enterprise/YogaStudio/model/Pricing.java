package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pricing")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricing_id", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false, precision = 13, scale = 2)
    private BigDecimal amount;

}