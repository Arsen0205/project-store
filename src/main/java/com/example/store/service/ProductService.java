package com.example.store.service;

import com.example.store.models.Product;
import com.example.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listProduct(String title){
        if(title != null) {
            return productRepository.findByTitle(title);
        }
        return productRepository.findAll();
    }

    public void saveProduct(Product product){
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
