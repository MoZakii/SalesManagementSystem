package com.Mohamed.SalesManagementSystem.service;

import com.Mohamed.SalesManagementSystem.model.Product;
import com.Mohamed.SalesManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    // Check if not empty
    public void updateProduct(Long id, Product updatedProduct){
        Optional<Product> product1 = productRepository.findById(id);
        if(product1.isPresent()){
            Product oldProduct = product1.get();
            oldProduct.setName(updatedProduct.getName());
            oldProduct.setCategory(updatedProduct.getCategory());
            oldProduct.setDescription(updatedProduct.getDescription());
            oldProduct.setPrice(updatedProduct.getPrice());
            oldProduct.setAvailableQuantity(updatedProduct.getAvailableQuantity());
            productRepository.save(oldProduct);
        }
    }

    public void deleteProduct(Long id){
        Optional<Product> product1 = productRepository.findById(id);
        product1.ifPresent(product -> productRepository.delete(product));
    }


}
