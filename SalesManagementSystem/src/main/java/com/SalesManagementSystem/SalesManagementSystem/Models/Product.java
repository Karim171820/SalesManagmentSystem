package com.SalesManagementSystem.SalesManagementSystem.Models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String description;
    private String category;
    private Date creationDate;
    private int availableQuantity;
    private int price;




    // Getters and setters
}