package com.Ecommerce.project.Service;



import com.Ecommerce.project.Entities.Orders;

import java.util.List;

public interface OrderService {
    void placeOrder(Integer user_Id);
    List<Orders> getOrderHistory(Integer user_Id);
    Orders getOrderById(Integer orderId);
}