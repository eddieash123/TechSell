import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Products } from '../models/Products';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private apiUrl = 'http://localhost:8080/product';

  constructor(private http: HttpClient) { }

  public getAllProducts(): Observable<Products[]> {
    return this.http.get<Products[]>(`${this.apiUrl}/get/all`)
  }

  public getProductsById(id:number): Observable<Products[]> {
    return this.http.get<Products[]>(`${this.apiUrl}/get/${id}`)
  }

  
}
