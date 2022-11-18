package com.example.refueling_service.mappers;

import com.example.refueling_service.dtos.ClientAndFuelDto;
import com.example.refueling_service.dtos.FuelDto;
import com.example.refueling_service.models.ClientAndFuel;
import com.example.refueling_service.models.Fuel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface FuelMapper {
    FuelMapper INSTANCE= Mappers.getMapper(FuelMapper.class);

    default Fuel fuel(FuelDto fuelDto){
        Fuel fuel=new Fuel();
        fuel.setId(fuelDto.getId());
        fuel.setName(fuelDto.getName());
        fuel.setPricePerLiter(fuelDto.getPricePerLiter());
        return fuel;}

   default FuelDto toFuelDto(Fuel fuel){
        FuelDto fuelDto=new FuelDto();
        fuelDto.setId(fuel.getId());
        fuelDto.setName(fuel.getName());
        fuelDto.setPricePerLiter(fuel.getPricePerLiter());

        return fuelDto;
    }
    default FuelDto fuelDto(Fuel user,List<ClientAndFuel> code) {

        List<ClientAndFuelDto> codeDtos = code.stream().map(ClientAndFuelMapper.INSTANCE::clientAndFuelDto).collect(Collectors.toList());
        FuelDto userDto = new FuelDto();
        userDto.setClientAndFuelDtos(codeDtos);
        userDto.setPricePerLiter(user.getPricePerLiter());
        userDto.setName(user.getName());
        userDto.setId(user.getId());
        return userDto;
    }

}
