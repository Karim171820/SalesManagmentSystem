package com.SalesManagementSystem.SalesManagementSystem.Dtos;

import lombok.Data;

import java.util.Date;
@Data
public class ProductOutputDto {
    public int id;
    public String name;

    public String description;
    public String category;
    public Date creationDate;
    public int availableQuantity;
    public int price;

}
