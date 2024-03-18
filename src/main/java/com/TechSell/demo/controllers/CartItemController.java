package com.TechSell.demo.controllers;

import com.TechSell.demo.models.CartItem;
import com.TechSell.demo.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartService;

    public CartItemController(CartItemService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestParam String username, @RequestBody CartItem cartItem) {
        try{
        cartService.addToCart(username, cartItem);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding item to the cart: " + e.getMessage());
        }
    }

    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getCartItems(@RequestParam String username) {
        List<CartItem> cartItems = cartService.getCartItems(username);
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFromCart(@RequestParam String username, @RequestParam int productId) {
        cartService.removeFromCart(username, productId);
        return ResponseEntity.ok().build();
    }
}
