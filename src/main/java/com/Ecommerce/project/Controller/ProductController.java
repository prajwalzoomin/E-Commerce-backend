package com.Ecommerce.project.Controller;

import com.Ecommerce.project.Entities.Product;
import com.Ecommerce.project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/pp")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable Integer productId, @RequestBody Product product) {
        productService.updateProduct(productId, product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }
}