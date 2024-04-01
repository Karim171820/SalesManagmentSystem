package com.SalesManagementSystem.SalesManagementSystem.Controller;

import com.SalesManagementSystem.SalesManagementSystem.Dtos.GetAllSalesOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Dtos.SaleOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import com.SalesManagementSystem.SalesManagementSystem.Models.Sale;
import com.SalesManagementSystem.SalesManagementSystem.Services.ProductService;
import com.SalesManagementSystem.SalesManagementSystem.Services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping
    public Sale createProduct(@RequestBody Sale sale) {
        return salesService.createSale(sale);
    }

    @GetMapping
    public GetAllSalesOutputDto getAllSalesWithTotalSaleValue() {
        return salesService.getAllSalesWithTotalSaleValue();
    }
}
