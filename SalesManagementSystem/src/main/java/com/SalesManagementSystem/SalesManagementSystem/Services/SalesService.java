package com.SalesManagementSystem.SalesManagementSystem.Services;

import com.SalesManagementSystem.SalesManagementSystem.Dtos.ClientOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Dtos.GetAllSalesOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Dtos.SaleOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Models.Client;
import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import com.SalesManagementSystem.SalesManagementSystem.Models.Sale;
import com.SalesManagementSystem.SalesManagementSystem.Repository.SaleRepository;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;
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
        GetAllSalesOutputDto saleDTO = new GetAllSalesOutputDto();
        SaleOutputDto saleOutputDto = new SaleOutputDto();
        for (Sale sale : sales) {
            saleOutputDto = this.modelMapper.map(sale, SaleOutputDto.class);
            saleDTO.getSales().add(saleOutputDto);
        }

        // Calculate total price separately
        double totalPrice = saleRepository.getTotalPriceOfAllSales();
        saleDTO.setTotalPrice(totalPrice);


        return saleDTO;
    }

}
