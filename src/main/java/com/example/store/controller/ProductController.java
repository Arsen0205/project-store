package com.example.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Класс, отвечающий за прием HTTP-запросов
@Controller
public class ProductController {
    @GetMapping("/")
    public String showProductsForm(){
        return "products";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
