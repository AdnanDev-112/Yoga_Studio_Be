package com.enterprise.software.ESED.CW.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "client_name", nullable = false, length = 150)
    private String clientName;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "client_discount_status", nullable = false)
    private boolean clientDiscountStatus;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private StudioModel studio;

}
