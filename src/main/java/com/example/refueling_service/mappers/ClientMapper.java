package com.example.refueling_service.mappers;

import com.example.refueling_service.dtos.ClientAndFuelDto;
import com.example.refueling_service.dtos.ClientDto;
import com.example.refueling_service.dtos.FuelDto;
import com.example.refueling_service.models.Client;
import com.example.refueling_service.models.ClientAndFuel;
import com.example.refueling_service.models.Fuel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE= Mappers.getMapper(ClientMapper.class);


    default Client toClient(ClientDto clientDto){
        Client client=new Client();
        client.setId(clientDto.getId());
        client.setEmail(clientDto.getEmail());
        return client;}

    default ClientDto toClientDto(Client client){
        ClientDto clientDto=new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setEmail(client.getEmail());
        return clientDto;
    }
    default ClientDto clientDtoFuel(Client client, List<ClientAndFuel> clientAndFuelList) {

        List<ClientAndFuelDto> codeDtos = clientAndFuelList
                .stream()
                .map(ClientAndFuelMapper.INSTANCE::clientAndFuelDto)
                .collect(Collectors.toList());
        ClientDto clientDto=new ClientDto();
        clientDto.setClientAndFuelDtos(codeDtos);
        clientDto.setId(client.getId());
        clientDto.setEmail(client.getEmail());
        return clientDto;
    }

}
