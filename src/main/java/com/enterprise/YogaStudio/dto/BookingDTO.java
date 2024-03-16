package com.enterprise.YogaStudio.dto;

import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.YogaSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Integer bookingid;
    private Client client;
    private YogaSession yogaSession;

}
