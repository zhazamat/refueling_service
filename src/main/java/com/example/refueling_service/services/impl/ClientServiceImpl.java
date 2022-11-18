package com.example.refueling_service.services.impl;

import com.example.refueling_service.dtos.ClientDto;
import com.example.refueling_service.mappers.ClientMapper;
import com.example.refueling_service.mappers.FuelMapper;
import com.example.refueling_service.models.Client;
import com.example.refueling_service.models.ClientAndFuel;
import com.example.refueling_service.repositories.ClientRepo;
import com.example.refueling_service.services.ClientAndFuelService;
import com.example.refueling_service.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

private final ClientAndFuelService clientAndFuelService;
    public ClientServiceImpl(ClientRepo clientRepo, ClientAndFuelService clientAndFuelService) {
        this.clientRepo = clientRepo;

        this.clientAndFuelService = clientAndFuelService;
    }


    @Override
    public List<ClientDto> findAll() {
        List<Client>clients=clientRepo.findAll();
        List<ClientDto> clientDtos = new ArrayList<>();
        for (Client client:clients) {
            List<ClientAndFuel>clientAndFuels=clientAndFuelService.findClientAndFuelByClientId(client.getId());
            clientDtos.add(ClientMapper.INSTANCE.clientDtoFuel(client,clientAndFuels));
        }
        return clientDtos;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client=ClientMapper.INSTANCE.toClient(clientDto);
        client=clientRepo.save(client);
        clientDto =ClientMapper.INSTANCE.toClientDto(client);
        return clientDto;
    }
}
