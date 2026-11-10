package com.example.restaurant.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity @Table(name="customer_orders")
public class CustomerOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String customerName;
 @Column(nullable=false,precision=10,scale=2) private BigDecimal totalAmount=BigDecimal.ZERO;
 @Column(nullable=false) private LocalDateTime createdAt=LocalDateTime.now();
 @Column(nullable=false) private String status="PLACED";
 @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true) private List<OrderLine> items=new ArrayList<>();
 protected CustomerOrder(){}
 public CustomerOrder(String customerName){this.customerName=customerName;}
 public void addItem(OrderLine line){items.add(line);line.setOrder(this);}
 public Long getId(){return id;} public String getCustomerName(){return customerName;} public BigDecimal getTotalAmount(){return totalAmount;}
 public LocalDateTime getCreatedAt(){return createdAt;} public String getStatus(){return status;} public List<OrderLine> getItems(){return items;}
 public void setTotalAmount(BigDecimal total){this.totalAmount=total;}
}
