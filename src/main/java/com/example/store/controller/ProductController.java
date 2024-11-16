package com.example.store.controller;

import com.example.store.models.Product;
import com.example.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

//Класс, отвечающий за прием HTTP-запросов
@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model){
        List<Product> products = productService.listProduct(title);
        model.addAttribute("products", products);
        return "products";
    }


    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Product product) throws IOException {
        log.info("Received files: file1={}, file2={}, file3={}", file1.getOriginalFilename(), file2.getOriginalFilename(), file3.getOriginalFilename());
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
