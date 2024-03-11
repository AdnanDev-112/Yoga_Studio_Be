package com.enterprise.YogaStudio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="studio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private Integer studioID;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;


    public void updateFrom(Studio updateStudio) {
        if (updateStudio != null) {
            this.setAddress(updateStudio.getAddress());
            this.setTelnum(updateStudio.getTelnum());
        }
    }

}
