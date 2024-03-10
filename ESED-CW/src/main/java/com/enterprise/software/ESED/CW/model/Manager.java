package com.enterprise.software.ESED.CW.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manager")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;

    @Column(name = "manager_name", nullable = false, length = 150)
    private String managerName;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "manager_type", nullable = false)
    private ManagerType managerType;

    public enum ManagerType {
        STUDIO,GENERAL
    }

}



