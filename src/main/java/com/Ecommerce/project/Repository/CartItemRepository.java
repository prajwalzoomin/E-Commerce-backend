package com.Ecommerce.project.Repository;

import com.Ecommerce.project.Entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUserId(Integer userId);
    void deleteByUserIdAndProductId(Integer userId, Integer productId);
}