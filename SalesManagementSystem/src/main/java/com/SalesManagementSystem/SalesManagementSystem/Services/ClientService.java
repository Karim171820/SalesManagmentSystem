package com.SalesManagementSystem.SalesManagementSystem.Services;

import com.SalesManagementSystem.SalesManagementSystem.Models.Client;
import com.SalesManagementSystem.SalesManagementSystem.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        try {
            return clientRepository.save(client);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client updateClient(Long id, Client client) {
        client.setId(id);
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
