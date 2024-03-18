package com.TechSell.demo.repos;
import com.TechSell.demo.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {

}
