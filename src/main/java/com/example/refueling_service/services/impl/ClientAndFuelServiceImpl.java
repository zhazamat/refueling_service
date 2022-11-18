package com.example.refueling_service.services.impl;

import com.example.refueling_service.dtos.ClientAndFuelDto;
import com.example.refueling_service.mappers.ClientAndFuelMapper;
import com.example.refueling_service.models.ClientAndFuel;
import com.example.refueling_service.repositories.ClientAndFuelRepo;
import com.example.refueling_service.services.ClientAndFuelService;
import com.example.refueling_service.services.ClientService;
import com.example.refueling_service.services.FuelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientAndFuelServiceImpl implements ClientAndFuelService {
    private final ClientAndFuelRepo clientAndFuelRepo;



    public ClientAndFuelServiceImpl(ClientAndFuelRepo clientAndFuelRepo) {
        this.clientAndFuelRepo = clientAndFuelRepo;

    }

    @Override
    public List<ClientAndFuelDto> findAll() {
        List<ClientAndFuel>clientAndFuels=clientAndFuelRepo.findAll();
        List<ClientAndFuelDto>clientAndFuelDTOS=clientAndFuels.
                stream()
                .map(x-> ClientAndFuelMapper.INSTANCE.clientAndFuelDto(x))
                .collect(Collectors.toList());
        return clientAndFuelDTOS;
    }

    @Override
    public List<ClientAndFuel> findClientAndFuelByFuelId(Long id) {
        return clientAndFuelRepo.findClientAndFuelByFuelId(id);
    }

    @Override
    public List<ClientAndFuel> findClientAndFuelByClientId(Long id) {

        return clientAndFuelRepo.findClientAndFuelByClientId(id);
    }

    @Override
    public ClientAndFuelDto save(ClientAndFuelDto clientAndFuelDto) {
        ClientAndFuel clientAndFuel=ClientAndFuelMapper.INSTANCE.clientAndFuel(clientAndFuelDto);
        clientAndFuel=clientAndFuelRepo.save(clientAndFuel);
        clientAndFuelDto =ClientAndFuelMapper.INSTANCE.clientAndFuelDto(clientAndFuel);
        return clientAndFuelDto;
    }
}
