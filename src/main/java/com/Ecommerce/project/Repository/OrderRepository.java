package com.Ecommerce.project.Repository;

import com.Ecommerce.project.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByUser_Id(Integer user_Id);
}