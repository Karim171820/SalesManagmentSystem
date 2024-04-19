package com.SalesManagementSystem.SalesManagementSystem.Repository;

import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import com.SalesManagementSystem.SalesManagementSystem.Models.Sale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository  extends JpaRepository<Sale, Long> {

    // Query method to get the total of all prices of all records
    @Query("SELECT SUM(s.saleValue) FROM Sale s")
    Double getTotalPriceOfAllSales();

}
