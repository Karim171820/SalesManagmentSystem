package com.SalesManagementSystem.SalesManagementSystem.Services;

import com.SalesManagementSystem.SalesManagementSystem.Dtos.ClientOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Models.Client;
import com.SalesManagementSystem.SalesManagementSystem.Repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Client createClient(Client client) {
        try {
            return clientRepository.save(client);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;
    }

    public List<ClientOutputDto> getAllClients() {
        List<Client> Clients = clientRepository.findAll();
        List<ClientOutputDto> ClientsDto = new ArrayList<>();
        for(Client client : Clients){
        ClientOutputDto ClientOutput = this.modelMapper.map(client, ClientOutputDto.class);
        ClientsDto.add(ClientOutput);
        }
        return ClientsDto;
    }

    public ClientOutputDto getClientById(Long id) {
        Client Client = clientRepository.findById(id).orElse(null);
        ClientOutputDto ClientDto = this.modelMapper.map(Client,ClientOutputDto.class);
        return ClientDto;
    }

    public Client updateClient(Long id, Client client) {
        client.setId(id);
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
