package com.Ecommerce.project.Controller;

import com.Ecommerce.project.Entities.CartItem;
import com.Ecommerce.project.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public void addToCart(@RequestBody CartItemRequest request) {
        cartService.addToCart(request.getUser_Id(), request.getProductId(), request.getQuantity());
    }


    @GetMapping("/{Id}")
    public List<CartItem> getCartItems(@PathVariable Integer Id) {
        return cartService.getCartItems(Id);
    }
}

