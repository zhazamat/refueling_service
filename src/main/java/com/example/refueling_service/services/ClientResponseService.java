package com.example.refueling_service.services;

import com.example.refueling_service.dtos.request.ClientRequest;
import org.springframework.stereotype.Service;

@Service
public interface ClientResponseService {
    ClientRequest getFuel(String email,String fuelName,String plateNumber,Double quantity);
    public String getEmail(String email);
}
