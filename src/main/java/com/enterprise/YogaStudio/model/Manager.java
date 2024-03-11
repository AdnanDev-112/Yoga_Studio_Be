package com.enterprise.YogaStudio.model;

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
    private Integer managerId;

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

    public void updateFrom(Manager manager) {
        if (manager != null) {
            this.setManagerName(manager.getManagerName());
            this.setAddress(manager.getAddress());
            this.setTelnum(manager.getTelnum());
            this.setEmail(manager.getEmail());
            this.setManagerType(manager.getManagerType());
        }
    }

    public enum ManagerType {
        STUDIO,GENERAL,studio,general
    }

}


//public class UpdateStudioRequest {
//    private Studio studio;
//    private Manager manager;              //to update both studio and manager
//
//    // Getters and setters (omitted for brevity)
//}