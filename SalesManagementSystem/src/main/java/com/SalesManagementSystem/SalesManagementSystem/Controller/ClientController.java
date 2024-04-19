package com.SalesManagementSystem.SalesManagementSystem.Controller;

import com.SalesManagementSystem.SalesManagementSystem.Dtos.ClientOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Models.Client;
import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import com.SalesManagementSystem.SalesManagementSystem.Services.ClientService;
import com.SalesManagementSystem.SalesManagementSystem.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }


    @GetMapping
    public List<ClientOutputDto> getAllClient() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientOutputDto getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id,client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
