package com.SalesManagementSystem.SalesManagementSystem.Dtos;

import lombok.Data;

import java.util.Date;

@Data
public class SaleOutputDto {
    private Long id;
    private Date date;
    private ClientOutputDto client;
//    private UserDTO seller;
}
