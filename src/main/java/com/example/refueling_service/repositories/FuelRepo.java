package com.example.refueling_service.repositories;

import com.example.refueling_service.models.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepo extends JpaRepository<Fuel,Long> {

}
