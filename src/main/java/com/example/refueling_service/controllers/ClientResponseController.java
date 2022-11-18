package com.example.refueling_service.controllers;

import com.example.refueling_service.models.Client;
import com.example.refueling_service.services.ClientResponseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/response")
public class ClientResponseController {
    private final ClientResponseService clientResponseService;

    public ClientResponseController(ClientResponseService clientResponseService) {
        this.clientResponseService = clientResponseService;
    }
    @PostMapping("/mail")
    public String getEmail(@RequestBody String email){
        return clientResponseService.getEmail(email);
    }
}
