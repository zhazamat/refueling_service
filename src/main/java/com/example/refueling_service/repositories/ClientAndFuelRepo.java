package com.example.refueling_service.repositories;

import com.example.refueling_service.dtos.ClientAndFuelDto;
import com.example.refueling_service.models.ClientAndFuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientAndFuelRepo extends JpaRepository<ClientAndFuel,Long> {
    List<ClientAndFuel>findClientAndFuelByFuelId(Long id);
    List<ClientAndFuel>findClientAndFuelByClientId(Long id);
}
