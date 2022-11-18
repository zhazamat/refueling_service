package com.example.refueling_service.controllers;

import com.example.refueling_service.dtos.ClientAndFuelDto;
import com.example.refueling_service.services.ClientAndFuelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client_and_fuel")
public class ClientAndFuelController {
    private final ClientAndFuelService clientAndFuelService;

    public ClientAndFuelController(ClientAndFuelService clientAndFuelService) {
        this.clientAndFuelService = clientAndFuelService;
    }
   @GetMapping("/list")
   public List<ClientAndFuelDto> getAll(){
        return clientAndFuelService.findAll();
   }
   @PostMapping ("save")
    public  ClientAndFuelDto save(@RequestBody ClientAndFuelDto clientAndFuelDto){
        return clientAndFuelService.save(clientAndFuelDto);
   }
}
