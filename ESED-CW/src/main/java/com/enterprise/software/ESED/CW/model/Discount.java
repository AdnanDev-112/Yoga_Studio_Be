package com.enterprise.software.ESED.CW.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "discount")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long discountId;

    @Column(name = "discount_description_name", nullable = false, length = 150)
    private String discountDescriptionName;

    @Column(name = "discount_value", nullable = false, length = 150)
    private String discountValue;

    @Column(name = "min_age", nullable = false)
    private Integer minAge;

    @Column(name = "max_age", nullable = false)
    private Integer maxAge;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

}
