package com.SalesManagementSystem.SalesManagementSystem.Dtos;

import lombok.Data;

@Data
public class ClientOutputDto {

    private Long id;
    private String name;
    private String lastName;
    private String mobile;
    private String email;
    private String address;
}
