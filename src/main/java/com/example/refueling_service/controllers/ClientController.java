package com.example.refueling_service.controllers;

import com.example.refueling_service.dtos.ClientDto;
import com.example.refueling_service.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/list")
    public List<ClientDto> getAll(){
        return clientService.findAll();
    }
    @PostMapping("/save")
    public  ClientDto save(@RequestBody ClientDto clientDto){
        return clientService.save(clientDto);
    }
}
