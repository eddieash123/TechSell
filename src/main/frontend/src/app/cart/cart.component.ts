import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{

  cartItems: any[] = [];
  userString: any = localStorage.getItem('user');
  user: any = JSON.parse(this.userString);

  constructor(private cartService: CartService) {}

  ngOnInit(): void {
    this.cartService.getCartItems(this.user.email).subscribe((items) => {
      this.cartItems = items;
      console.log(this.cartItems)
    });
  }
}
