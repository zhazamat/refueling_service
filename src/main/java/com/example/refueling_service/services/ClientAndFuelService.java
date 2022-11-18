package com.example.refueling_service.services;

import com.example.refueling_service.dtos.ClientAndFuelDto;
import com.example.refueling_service.models.ClientAndFuel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientAndFuelService {
    List<ClientAndFuelDto> findAll();
    List<ClientAndFuel>findClientAndFuelByFuelId(Long id);
    List<ClientAndFuel>findClientAndFuelByClientId(Long id);

    ClientAndFuelDto save(ClientAndFuelDto clientAndFuelDto);
}
