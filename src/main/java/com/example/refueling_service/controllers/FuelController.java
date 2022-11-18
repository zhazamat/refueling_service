package com.example.refueling_service.controllers;

import com.example.refueling_service.dtos.FuelDto;
import com.example.refueling_service.services.FuelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fuel")
public class FuelController {
    private final FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @GetMapping ("/list")
    public List<FuelDto> getAll(){
        return fuelService.finAll();
    }
    @PostMapping ("/save")
    public FuelDto save(@RequestBody FuelDto fuelDto){
        return fuelService.save(fuelDto);
    }
}
