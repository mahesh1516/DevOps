package com.example.restaurant.service;
import com.example.restaurant.model.MenuItem;
import com.example.restaurant.repository.MenuItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MenuService {
 private final MenuItemRepository repository;
 public MenuService(MenuItemRepository repository){this.repository=repository;}
 public List<MenuItem> getAll(){return repository.findAll();}
 public MenuItem getById(Long id){return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Menu item not found: "+id));}
}
