package com.enterprise.YogaStudio.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {
    private Integer id;
    private String managerName;
    private String address;
    private String telnum;
    private String email;
    private String managerType;

}
