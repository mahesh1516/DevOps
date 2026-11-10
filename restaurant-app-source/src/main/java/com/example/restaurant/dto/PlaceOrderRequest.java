package com.example.restaurant.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
public record PlaceOrderRequest(@NotBlank String customerName,@NotEmpty List<@Valid OrderItemRequest> items) {
 public record OrderItemRequest(@NotNull Long menuItemId,@NotNull @Positive Integer quantity) {}
}
