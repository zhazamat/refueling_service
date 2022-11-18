package com.example.refueling_service.services;

import com.example.refueling_service.dtos.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClientService {
     List<ClientDto> findAll();

    ClientDto save(ClientDto clientDto);
}
