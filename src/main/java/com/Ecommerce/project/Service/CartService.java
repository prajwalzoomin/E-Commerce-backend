package com.Ecommerce.project.Service;


import com.Ecommerce.project.Entities.CartItem;

import java.util.List;

public interface CartService {
    void addToCart(Integer userId, Integer productId, Integer quantity);
    void updateCart(Integer userId, Integer productId, Integer quantity);
//    void removeFromCart(Integer userId, Integer productId);
    List<CartItem> getCartItems(Integer userId);
}

