package com.example.zwigato.dto.response;



import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RestaurantResponse {

    private String name;

    private String location;

    boolean isOpen;

    Date registeredAt;
}
