package com.SalesManagementSystem.SalesManagementSystem.Models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String mobile;
    private String email;
    private String address;

    // Getters and setters
}
