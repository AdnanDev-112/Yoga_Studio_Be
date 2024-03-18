package com.enterprise.YogaStudio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudioDTO {
    private Integer id;
    private String address;
    private String telnum;
    private ManagerDTO manager;


}