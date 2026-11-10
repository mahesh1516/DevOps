package com.example.restaurant.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="menu_items")
public class MenuItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(length=1000) private String description;
 @Column(nullable=false, precision=10, scale=2) private BigDecimal price;
 @Column(nullable=false) private boolean available=true;
 protected MenuItem() {}
 public MenuItem(String name,String description,BigDecimal price,boolean available){this.name=name;this.description=description;this.price=price;this.available=available;}
 public Long getId(){return id;} public String getName(){return name;} public String getDescription(){return description;}
 public BigDecimal getPrice(){return price;} public boolean isAvailable(){return available;}
}
