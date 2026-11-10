package com.example.restaurant.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="order_lines")
public class OrderLine {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="order_id") private CustomerOrder order;
 @Column(nullable=false) private Long menuItemId;
 @Column(nullable=false) private String itemName;
 @Column(nullable=false) private Integer quantity;
 @Column(nullable=false,precision=10,scale=2) private BigDecimal unitPrice;
 protected OrderLine(){}
 public OrderLine(Long menuItemId,String itemName,Integer quantity,BigDecimal unitPrice){this.menuItemId=menuItemId;this.itemName=itemName;this.quantity=quantity;this.unitPrice=unitPrice;}
 void setOrder(CustomerOrder order){this.order=order;}
 public Long getId(){return id;} public Long getMenuItemId(){return menuItemId;} public String getItemName(){return itemName;}
 public Integer getQuantity(){return quantity;} public BigDecimal getUnitPrice(){return unitPrice;}
}
