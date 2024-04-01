package com.SalesManagementSystem.SalesManagementSystem.Dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllSalesOutputDto {
    private List<SaleOutputDto> sales;
    private double totalPrice;

    public GetAllSalesOutputDto() {
        this.sales = new ArrayList<>();
    }
}
