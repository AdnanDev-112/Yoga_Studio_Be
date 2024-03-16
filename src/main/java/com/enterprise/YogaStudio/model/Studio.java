package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "STUDIO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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


    @JsonIgnore
    @OneToMany(mappedBy = "studio")
    private Set<Client> clients = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "studio")
    private Set<Course> courses = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "studio")
    private Set<YogaSession> yogaSessions = new LinkedHashSet<>();

}