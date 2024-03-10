package com.enterprise.software.ESED.CW.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "activity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @Column(name = "activity_type", nullable = false, length = 150)
    private String activityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private Level level;

    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "recurring", nullable = false)
    private boolean recurring;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private StudioModel studio;

    private enum Level{
        BEGINNER,INTERIM,ADVANCED
    }

}
