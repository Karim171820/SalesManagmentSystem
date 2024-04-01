package com.SalesManagementSystem.SalesManagementSystem.Repository;
import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ProductRepository extends JpaRepository<Product, Long> {

}
