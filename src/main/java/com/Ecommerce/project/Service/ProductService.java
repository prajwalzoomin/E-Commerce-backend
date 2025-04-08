package com.Ecommerce.project.Service;


import com.Ecommerce.project.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);
    void updateProduct(Integer productId, Product product);



    List<Product> getAllProducts();
    Optional<Product> getProductById(Integer productId);
}
