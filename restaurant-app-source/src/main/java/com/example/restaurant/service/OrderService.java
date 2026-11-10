package com.example.restaurant.service;
import com.example.restaurant.dto.PlaceOrderRequest;
import com.example.restaurant.model.*;
import com.example.restaurant.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
@Service
public class OrderService {
 private final CustomerOrderRepository orders; private final MenuItemRepository menu;
 public OrderService(CustomerOrderRepository orders,MenuItemRepository menu){this.orders=orders;this.menu=menu;}
 @Transactional public CustomerOrder placeOrder(PlaceOrderRequest request){
  CustomerOrder order=new CustomerOrder(request.customerName()); BigDecimal total=BigDecimal.ZERO;
  for(var requested:request.items()){
   MenuItem item=menu.findById(requested.menuItemId()).orElseThrow(()->new ResourceNotFoundException("Menu item not found: "+requested.menuItemId()));
   if(!item.isAvailable()) throw new IllegalArgumentException("Menu item is unavailable: "+item.getName());
   order.addItem(new OrderLine(item.getId(),item.getName(),requested.quantity(),item.getPrice()));
   total=total.add(item.getPrice().multiply(BigDecimal.valueOf(requested.quantity())));
  }
  order.setTotalAmount(total); return orders.save(order);
 }
 @Transactional(readOnly=true) public CustomerOrder getOrder(Long id){return orders.findById(id).orElseThrow(()->new ResourceNotFoundException("Order not found: "+id));}
}
