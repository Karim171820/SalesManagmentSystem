package com.SalesManagementSystem.SalesManagementSystem.Repository;

import com.SalesManagementSystem.SalesManagementSystem.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
