package com.Mohamed.SalesManagementSystem.service;

import com.Mohamed.SalesManagementSystem.model.Client;
import com.Mohamed.SalesManagementSystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client updatedClient){
        Optional<Client> client1 = clientRepository.findById(id);
        if(client1.isPresent()){
            updatedClient.setId(id);
            return clientRepository.save(updatedClient);
        }
        return null;
    }

    public boolean deleteClient(Long id){
        boolean exists = clientRepository.existsById(id);
        if(exists){
            clientRepository.deleteById(id);
        }
        return exists;
    }



}
