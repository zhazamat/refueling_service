package com.example.refueling_service.services.impl;

import com.example.refueling_service.dtos.request.ClientRequest;
import com.example.refueling_service.models.Client;
import com.example.refueling_service.repositories.ClientRepo;
import com.example.refueling_service.services.ClientResponseService;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Service
public class ClientResponseServiceImpl implements ClientResponseService {
    private final ClientRepo clientRepo;

    public ClientResponseServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public ClientRequest getFuel(String email, String fuelName, String plateNumber, Double quantity) {
      // List<Client>clients=getEmail(email);
        return null;
    }
    @Override
    public String getEmail(String email){
        String k="";
        for(Client client:clientRepo.findAll()){

            if(Objects.isNull(client)){
                throw new RuntimeException("Client is null");
            }
            else if(!client.getEmail().equals(email)){
             client.setEmail(email);
              k=client.getEmail();
             clientRepo.save(client);
            }
            else{ k=client.getEmail();}
        }
        return k;
    }
}
