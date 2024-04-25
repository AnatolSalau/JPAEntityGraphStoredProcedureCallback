package com.example.jpaentitygraphstoredprocedurecallback.controller;

import com.example.jpaentitygraphstoredprocedurecallback.entity.Client;
import com.example.jpaentitygraphstoredprocedurecallback.repository.ClientRepository;
import com.example.jpaentitygraphstoredprocedurecallback.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;
    @Autowired
    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fillDB")
    public String fillDataBase() {
        clientService.generateDB();
        return "Amount clients: " + clientRepository.count();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/by_name")
    public List<Client> findByNameContaining(@RequestParam String clientName) {
        List<Client> clients = clientService.findByNameContaining(clientName);
        return clients;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/by_name_native")
    public List<Client> findByNameContainingEmNative(@RequestParam String clientName) {
        List<Client> clients = clientService.findByNameContainingEmNative(clientName);
        return clients;
    }

}