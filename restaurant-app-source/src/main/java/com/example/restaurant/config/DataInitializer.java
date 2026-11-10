package com.example.restaurant.config;
import com.example.restaurant.model.MenuItem;
import com.example.restaurant.repository.MenuItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import java.math.BigDecimal;
@Configuration
public class DataInitializer {
 @Bean CommandLineRunner loadMenu(MenuItemRepository repo){return args->{
  if(repo.count()==0){
   repo.save(new MenuItem("Veg Biryani","Aromatic rice with vegetables",new BigDecimal("180.00"),true));
   repo.save(new MenuItem("Paneer Butter Masala","Paneer in creamy tomato gravy",new BigDecimal("220.00"),true));
   repo.save(new MenuItem("Masala Dosa","Crispy dosa with chutney and sambar",new BigDecimal("90.00"),true));
   repo.save(new MenuItem("Gulab Jamun","Milk dumplings in sugar syrup",new BigDecimal("60.00"),true));
  }
 };}
}
