package com.SalesManagementSystem.SalesManagementSystem.Services;
import com.SalesManagementSystem.SalesManagementSystem.Dtos.ProductOutputDto;
import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import com.SalesManagementSystem.SalesManagementSystem.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Product createProduct(Product product) {
        try {
            return productRepository.save(product);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;
    }

    public List<ProductOutputDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductOutputDto> productsDto = new ArrayList<>();

        for (Product product : products) {
            ProductOutputDto productDto = modelMapper.map(product, ProductOutputDto.class);
            productsDto.add(productDto);
        }

        return productsDto;
    }

    public ProductOutputDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductOutputDto productDto = this.modelMapper.map(product, ProductOutputDto.class);
        return productDto;
    }

//    public Product updateUser(Long id, Product product) {
//        product.setId(id);
//        return productRepository.save(product);
//    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
