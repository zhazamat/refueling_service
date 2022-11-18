package com.example.refueling_service.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {
    Long id;
    String email;
    List<ClientAndFuelDto>clientAndFuelDtos;
}
