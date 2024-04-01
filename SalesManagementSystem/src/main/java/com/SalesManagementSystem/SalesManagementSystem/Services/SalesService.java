package com.SalesManagementSystem.SalesManagementSystem.Services;

import com.SalesManagementSystem.SalesManagementSystem.Dtos.ClientOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Dtos.GetAllSalesOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Dtos.SaleOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Models.Client;
import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import com.SalesManagementSystem.SalesManagementSystem.Models.Sale;
import com.SalesManagementSystem.SalesManagementSystem.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

@Service
public class SalesService {

    private final SaleRepository saleRepository;

    @Autowired
    public SalesService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    // Method to get all sales along with the total sale value

    public Sale createSale(Sale sale) {
        try {
            return saleRepository.save(sale);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;
    }

    public GetAllSalesOutputDto getAllSalesWithTotalSaleValue() {
        List<Sale> sales = saleRepository.findAll();
        List<SaleOutputDto> AllSales = new ArrayList<>();
        GetAllSalesOutputDto saleDTO = new GetAllSalesOutputDto(); // Create a new instance for each Sale
        SaleOutputDto saleOutputDto = new SaleOutputDto();
        for (Sale sale : sales) {
            saleOutputDto.setId(sale.getId());
            saleOutputDto.setDate(sale.getDate());
            saleOutputDto.setClient(mapToClientDTO(sale.getClient())); // Assuming you have a method to map Client entity to ClientDTO
            saleDTO.getSales().add(saleOutputDto);
            AllSales.add(saleOutputDto);
        }

        // Calculate total price separately
        double totalPrice = saleRepository.getTotalPriceOfAllSales();
        saleDTO.setTotalPrice(totalPrice);


        return saleDTO;
    }
    private ClientOutputDto mapToClientDTO(Client client) {
        if (client == null) {
            return null;
        }

        ClientOutputDto clientDTO = new ClientOutputDto();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setMobile(client.getMobile());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setAddress(client.getAddress());

        return clientDTO;
    }

}
