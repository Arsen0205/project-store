package com.example.store.service;

import com.example.store.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "PlayStation 5", "Игровая консоль нового поколения", 70000, "Краснодар", "Sony"));
        products.add(new Product(++ID, "Iphone 16 pro Max", "Смартфон", 70000, "Краснодар", "Apple"));
    }

    public List<Product> listProduct(){return products;}

    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(long id){
        products.removeIf(product -> product.getId() == id);
    }

    public Product getProductById(long id) {
       for (Product product : products){
           if(product.getId() == id) return product;
       }
       return null;
    }
}
