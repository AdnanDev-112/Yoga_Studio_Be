package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "INSTRUCTOR")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id", nullable = false)
    private Integer id;

    @Column(name = "instructor_name", nullable = false, length = 150)
    private String instructorName;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @Column(name = "type", nullable = false, length = 16)
    private String type;

}