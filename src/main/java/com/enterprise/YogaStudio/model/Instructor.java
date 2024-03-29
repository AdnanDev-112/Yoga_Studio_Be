package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "instructor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id", nullable = false)
    private Integer id;

    @Column(name = "instructor_name", nullable = false, length = 150)
    private String instructorName;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

}