package com.enterprise.software.ESED.CW.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="studio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private Long studioId;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

}
