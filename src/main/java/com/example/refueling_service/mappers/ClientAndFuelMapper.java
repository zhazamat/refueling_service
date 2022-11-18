package com.example.refueling_service.mappers;

import com.example.refueling_service.dtos.ClientAndFuelDto;
import com.example.refueling_service.models.ClientAndFuel;
import com.example.refueling_service.models.enums.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;
@Mapper
public interface ClientAndFuelMapper {
    ClientAndFuelMapper INSTANCE= Mappers.getMapper(ClientAndFuelMapper.class);
   // ClientAndFuel toClientAndFuel(ClientAndFuelDto clientAndFuelDto);
   // ClientAndFuelDto toClientAndFuelDto(ClientAndFuel clientAndFuel);
    default ClientAndFuel clientAndFuel(ClientAndFuelDto userDto){
        ClientAndFuel user=new ClientAndFuel();
        user.setAmount(userDto.getAmount());
        user.setChange(userDto.getChange());
        user.setCreatedDate(userDto.getCreatedDate());
        user.setVolume(userDto.getVolume());
        user.setId(userDto.getId());
        //user.setPayStatus(Status.PENDING);
        user.setFuel(FuelMapper.INSTANCE.fuel(userDto.getFuelDto()));
        user.setClient(ClientMapper.INSTANCE.toClient(userDto.getClientDto()));
        return user;
    }
    default ClientAndFuelDto clientAndFuelDto(ClientAndFuel clientAndFuel){
        ClientAndFuelDto codeDto=new ClientAndFuelDto();
        codeDto.setAmount(clientAndFuel.getAmount());
        codeDto.setChange(clientAndFuel.getChange());
        codeDto.setId(clientAndFuel.getId());
        codeDto.setCreatedDate(clientAndFuel.getCreatedDate());
        codeDto.setVolume(clientAndFuel.getVolume());
        codeDto.setFuelDto(FuelMapper.INSTANCE.toFuelDto(clientAndFuel.getFuel()));
        codeDto.setClientDto(ClientMapper.INSTANCE.toClientDto(clientAndFuel.getClient()));
        codeDto.setPlateNumber(clientAndFuel.getPlateNumber());
        return codeDto;
    }
}
