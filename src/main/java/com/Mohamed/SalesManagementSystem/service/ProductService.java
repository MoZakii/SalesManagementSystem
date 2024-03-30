package com.Mohamed.SalesManagementSystem.service;

import com.Mohamed.SalesManagementSystem.model.Product;
import com.Mohamed.SalesManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct){
        Optional<Product> product1 = productRepository.findById(id);
        if(product1.isPresent()){
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public boolean deleteProduct(Long id){
        boolean exists = productRepository.existsById(id);
        if(exists){
            productRepository.deleteById(id);
        }
        return exists;
    }


}
