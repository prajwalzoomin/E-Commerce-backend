package com.Ecommerce.project.Controller;

import com.Ecommerce.project.Entities.Orders;
import com.Ecommerce.project.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public void placeOrder(@RequestBody OrderRequest request) {
        orderService.placeOrder(request.getUser_Id());
    }


    @GetMapping
    public List<Orders> getOrderHistory(@RequestParam Integer user_Id) {
        return orderService.getOrderHistory(user_Id);
    }

    @GetMapping("/{orderId}")
    public Orders getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }
}
