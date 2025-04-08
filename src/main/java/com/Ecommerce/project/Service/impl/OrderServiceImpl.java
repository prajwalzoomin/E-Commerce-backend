package com.Ecommerce.project.Service.impl;



import com.Ecommerce.project.Entities.CartItem;
import com.Ecommerce.project.Entities.Orders;
import com.Ecommerce.project.Entities.OrderItem;
import com.Ecommerce.project.Repository.CartItemRepository;
import com.Ecommerce.project.Repository.OrderItemRepository;
import com.Ecommerce.project.Repository.OrderRepository;
import com.Ecommerce.project.Repository.UserRepository;
import com.Ecommerce.project.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void placeOrder(Integer user_Id) {
        List<CartItem> cartItems = cartItemRepository.findByUserId(user_Id);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Orders order = new Orders();
        order.setUser(userRepository.findById(user_Id)
                .orElseThrow(() -> new RuntimeException("User not found")));
        order.setOrderDate(new java.util.Date());
        orderRepository.save(order);

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItemRepository.save(orderItem);
        }

        cartItemRepository.deleteAll(cartItems);
    }

    @Override
    public List<Orders> getOrderHistory(Integer user_Id) {
        return orderRepository.findByUser_Id(user_Id);
    }

    @Override
    public Orders getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
