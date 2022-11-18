package com.example.refueling_service.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuelDto {
    Long id;
    String name;
    Double pricePerLiter;
    List<ClientAndFuelDto> clientAndFuelDtos;
}
