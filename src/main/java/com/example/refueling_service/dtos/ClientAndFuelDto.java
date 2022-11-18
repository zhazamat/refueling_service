package com.example.refueling_service.dtos;

import com.example.refueling_service.models.Client;
import com.example.refueling_service.models.Fuel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.engine.spi.Status;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@Getter
@Setter
@FieldDefaults (level = AccessLevel.PRIVATE)
public class ClientAndFuelDto {
    Long id;
    Double volume;
    ClientDto clientDto;
    FuelDto  fuelDto;
    Double amount;
    Double change;
    String plateNumber;
    Status payStatus;
    Date createdDate;
}
