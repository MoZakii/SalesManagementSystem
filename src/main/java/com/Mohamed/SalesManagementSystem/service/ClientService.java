package com.Mohamed.SalesManagementSystem.service;

import com.Mohamed.SalesManagementSystem.model.Client;
import com.Mohamed.SalesManagementSystem.model.Product;
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

    public void createClient(Client client){
        clientRepository.save(client);
    }

    //Check if fields exist
    public void updateClient(Long id, Client updatedClient){
        Optional<Client> client1 = clientRepository.findById(id);
        if(client1.isPresent()){
            Client oldClient = client1.get();
            oldClient.setName(updatedClient.getName());
            oldClient.setLastName(updatedClient.getLastName());
            oldClient.setMobile(updatedClient.getMobile());
            oldClient.setEmail(updatedClient.getEmail());
            oldClient.setAddress(updatedClient.getAddress());
            clientRepository.save(oldClient);
        }
    }

    public void deleteClient(Long id){
        Optional<Client> client1 = clientRepository.findById(id);
        client1.ifPresent(client -> clientRepository.delete(client));
    }



}
