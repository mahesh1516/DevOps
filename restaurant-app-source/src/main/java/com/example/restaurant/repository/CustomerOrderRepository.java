package com.example.restaurant.repository;
import com.example.restaurant.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {}
