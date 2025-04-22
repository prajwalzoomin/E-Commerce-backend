package com.Ecommerce.project.Service.impl;


import com.Ecommerce.project.Entities.CartItem;
import com.Ecommerce.project.Entities.Product;
import com.Ecommerce.project.Repository.CartItemRepository;
import com.Ecommerce.project.Repository.ProductRepository;
import com.Ecommerce.project.Repository.UserRepository;
import com.Ecommerce.project.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addToCart(Integer userId, Integer productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem cartItem = new CartItem();
        cartItem.setUser(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void updateCart(Integer userId, Integer productId, Integer quantity) {
        CartItem cartItem = cartItemRepository.findByUserId(userId).stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

//    @Override
//    public void removeFromCart(Integer userId, Integer productId) {
//        List<CartItem> items = cartItemRepository.findByUserId(userId);
//        boolean exists = items.stream().anyMatch(item -> item.getProduct().getId().equals(productId));
//        if (!exists) {
//            throw new RuntimeException("Cart item not found for userId: " + userId + " and productId: " + productId);
//        }
//        cartItemRepository.deleteByUserIdAndProductId(userId, productId);
//    }

    @Override
    public List<CartItem> getCartItems(Integer userId) {
        return cartItemRepository.findByUserId(userId);
    }
}