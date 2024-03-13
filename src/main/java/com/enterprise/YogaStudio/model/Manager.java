package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MANAGER")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id", nullable = false)
    private Integer id;

    @Column(name = "manager_name", nullable = false, length = 150)
    private String managerName;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Lob
    @Column(name = "manager_type", nullable = false)
    private String managerType;

}