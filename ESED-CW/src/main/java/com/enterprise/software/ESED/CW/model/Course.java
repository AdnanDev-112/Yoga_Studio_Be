package com.enterprise.software.ESED.CW.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "pricing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name", nullable = false, length = 150)
    private String courseName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "number_of_classes", nullable = false)
    private Integer numberOfClasses;

    @ManyToOne
    @JoinColumn(name = "pricing_id", nullable = false)
    private Pricing pricing;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private StudioModel studio;


}
