package com.SalesManagementSystem.SalesManagementSystem.Controller;

import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import com.SalesManagementSystem.SalesManagementSystem.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

//    @PutMapping("/{id}")
//    public Product updateUser(@PathVariable Long id, @RequestBody Product product) {
//        return productService.updateUser(id, product);
//    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
