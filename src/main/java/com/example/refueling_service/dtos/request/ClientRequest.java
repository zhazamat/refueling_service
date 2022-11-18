package com.example.refueling_service.dtos.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientRequest {
    String email;
    String fuelName;
    String plateNumber;
    Double quantity;


}
