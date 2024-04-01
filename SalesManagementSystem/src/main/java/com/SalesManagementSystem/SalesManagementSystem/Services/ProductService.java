package com.SalesManagementSystem.SalesManagementSystem.Services;
import com.SalesManagementSystem.SalesManagementSystem.Models.Product;
import com.SalesManagementSystem.SalesManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        try {
            return productRepository.save(product);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

//    public Product updateUser(Long id, Product product) {
//        product.setId(id);
//        return productRepository.save(product);
//    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
