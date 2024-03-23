package com.enterprise.YogaStudio.dto;
import com.enterprise.YogaStudio.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddBookingDTO {
        private Integer clientId;
        private Integer scheduleId;
        private String category_type;
        private String categorySubType;
}

