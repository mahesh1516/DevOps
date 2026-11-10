package com.example.restaurant.controller;
import com.example.restaurant.dto.PlaceOrderRequest;
import com.example.restaurant.model.CustomerOrder;
import com.example.restaurant.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/orders")
public class OrderController {
 private final OrderService service;
 public OrderController(OrderService service){this.service=service;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED)
 public CustomerOrder placeOrder(@Valid @RequestBody PlaceOrderRequest request){return service.placeOrder(request);}
 @GetMapping("/{id}") public CustomerOrder getOrder(@PathVariable Long id){return service.getOrder(id);}
}
