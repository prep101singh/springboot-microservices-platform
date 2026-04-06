package com.platform.product_service.controller;

import com.platform.product_service.entity.Product;
import com.platform.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This annotation indicates that this class is a REST controller.
@RequestMapping("/products") // This annotation maps HTTP requests to handler methods of this controller.
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    private List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    private Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    private Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
