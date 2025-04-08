package com.Ecommerce.project.Service.impl;



import com.Ecommerce.project.Entities.Product;
import com.Ecommerce.project.Repository.ProductRepository;
import com.Ecommerce.project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Integer productId, Product product) {

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer productId) {
        return productRepository.findById(productId);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(Math.toIntExact(id)).orElse(null);
    }
}