package com.example.restaurant.controller;
import com.example.restaurant.model.MenuItem;
import com.example.restaurant.service.MenuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/menu")
public class MenuController {
 private final MenuService service;
 public MenuController(MenuService service){this.service=service;}
 @GetMapping public List<MenuItem> getMenu(){return service.getAll();}
 @GetMapping("/{id}") public MenuItem getMenuItem(@PathVariable Long id){return service.getById(id);}
}
