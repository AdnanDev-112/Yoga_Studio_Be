package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "STUDIO")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id", nullable = false)
    private Integer id;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @OneToMany(mappedBy = "studio")
    private Set<Client> clients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "studio")
    private Set<Course> courses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "studio")
    private Set<YogaSession> yogaSessions = new LinkedHashSet<>();

}