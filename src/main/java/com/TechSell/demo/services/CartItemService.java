package com.TechSell.demo.services;

import com.TechSell.demo.models.CartItem;
import com.TechSell.demo.models.Users;
import com.TechSell.demo.repos.CartItemRepo;
import com.TechSell.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private CartItemRepo cartItemRepository;

    public CartItemService(UserRepo userRepository, CartItemRepo cartItemRepository) {
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public void addToCart(String username, CartItem cartItem) {
        Users user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.getCart().add(cartItem);
        userRepository.save(user);
    }

    public List<CartItem> getCartItems(String username) {
        Users user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getCart();
    }

    public void removeFromCart(String username, int productId) {
        Users user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.getCart().removeIf(cartItem -> cartItem.getProductId() == productId);
        userRepository.save(user);
    }
}
