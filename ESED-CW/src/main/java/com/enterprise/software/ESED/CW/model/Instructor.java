package com.enterprise.software.ESED.CW.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "instructor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private Long instructorId;

    @Column(name = "instructor_name", nullable = false, length = 150)
    private String instructorName;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @Column(name = "type", nullable = false, length = 16)
    private String type;

}
