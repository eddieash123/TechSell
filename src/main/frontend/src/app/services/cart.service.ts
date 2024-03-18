import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../models/Cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private apiUrl = 'http://localhost:8080/cart';

  constructor(private http: HttpClient) { }

  addToCart(username: string, cartItem: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/add?username=${username}`, cartItem);
  }

  getCartItems(username: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/items?username=${username}`);
  }

  removeFromCart(username: string, cartItemId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/remove?username=${username}&cartItemId=${cartItemId}`);
  }
  
}
