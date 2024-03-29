package com.Mohamed.SalesManagementSystem.controller;

import com.Mohamed.SalesManagementSystem.model.Client;
import com.Mohamed.SalesManagementSystem.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients(){
        return clientService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@Valid @RequestBody Client client){
        Client addedClient = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@Valid @RequestBody Client client, @PathVariable Long id){
        Client updatedClient = clientService.updateClient(id, client);
        if (updatedClient != null) {
            return ResponseEntity.ok(updatedClient);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id){
        boolean deleted = clientService.deleteClient(id);
        if(deleted)
            return ResponseEntity.noContent().build();
        else
            throw new EntityNotFoundException();
    }
}
