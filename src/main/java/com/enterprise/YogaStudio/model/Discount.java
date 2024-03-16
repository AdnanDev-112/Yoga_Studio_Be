package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "discount")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id", nullable = false)
    private Integer id;

    @Column(name = "discount_description_name", nullable = false, length = 150)
    private String discountDescriptionName;

    @Column(name = "discount_value", nullable = false, length = 150)
    private String discountValue;

    @Column(name = "min_age", nullable = false)
    private Integer minAge;

    @Column(name = "max_age", nullable = false)
    private Integer maxAge;

}