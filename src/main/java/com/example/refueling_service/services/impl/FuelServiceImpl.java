package com.example.refueling_service.services.impl;

import com.example.refueling_service.dtos.FuelDto;
import com.example.refueling_service.mappers.FuelMapper;
import com.example.refueling_service.models.ClientAndFuel;
import com.example.refueling_service.models.Fuel;
import com.example.refueling_service.repositories.ClientAndFuelRepo;
import com.example.refueling_service.repositories.FuelRepo;
import com.example.refueling_service.services.ClientAndFuelService;
import com.example.refueling_service.services.FuelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuelServiceImpl implements FuelService {
    private final FuelRepo fuelRepo;
    private  final ClientAndFuelService clientAndFuelService;
private final ClientAndFuelRepo clientAndFuelRepo;
    public FuelServiceImpl(FuelRepo fuelRepo, ClientAndFuelService clientAndFuelService, ClientAndFuelRepo clientAndFuelRepo) {
        this.fuelRepo = fuelRepo;
        this.clientAndFuelService = clientAndFuelService;
        this.clientAndFuelRepo = clientAndFuelRepo;
    }

    @Override
    public List<FuelDto> finAll() {
        List<Fuel>fuels=fuelRepo.findAll();
        List<FuelDto> fuelDtos = new ArrayList<>();
        for (Fuel fuel : fuels) {
            List<ClientAndFuel>clientAndFuels=clientAndFuelService.findClientAndFuelByFuelId(fuel.getId());
            fuelDtos.add(FuelMapper.INSTANCE.fuelDto(fuel,clientAndFuels));
        }
        return fuelDtos;
    }

    @Override
    public FuelDto save(FuelDto fuelDto) {
        Fuel fuel=FuelMapper.INSTANCE.fuel(fuelDto);
        fuel=fuelRepo.save(fuel);
        fuelDto =FuelMapper.INSTANCE.toFuelDto(fuel);
        return fuelDto;
    }
}
