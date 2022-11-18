package com.example.refueling_service.services;

import com.example.refueling_service.dtos.FuelDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FuelService {
    List<FuelDto> finAll() ;

    FuelDto save(FuelDto fuelDto);
}
