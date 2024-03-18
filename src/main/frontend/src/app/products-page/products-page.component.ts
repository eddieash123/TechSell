import { Component } from '@angular/core';
import { Cart } from '../models/Cart';
import { Products } from '../models/Products';
import { CartService } from '../services/cart.service';
import { ProductsService } from '../services/products.service';

@Component({
  selector: 'app-products-page',
  templateUrl: './products-page.component.html',
  styleUrls: ['./products-page.component.css']
})
export class ProductsPageComponent {
  allProducts: Products[] = [];
  products: Products[] = [];
  filteredList: Products[] = [];
  searchResult: string | null = "Products"
  colorOption: any = null
  priceOption: any = null

  user: any

  constructor(private productService: ProductsService, private cartService: CartService){}

  ngOnInit() {
    
    if (localStorage.getItem('searchStr') === "Products"){
      this.productService.getAllProducts().subscribe(res => {
        for(let i =0; i<res.length; i++) {
         if(this.searchResult !== null && this.searchResult === "Products") {
            this.allProducts = res
            this.products[i] = res[i]
            this.filteredList[i] = res[i]
          }
          else if(this.searchResult !== null && res[i].category === this.searchResult) {
            this.products.push(res[i]) 
          }
        }
      })
    }
    else if (localStorage.getItem('searchStr') !== "") {
      this.searchResult = localStorage.getItem('searchStr');
      this.productService.getAllProducts().subscribe(res => {
        for(let i =0; i<res.length; i++) {
          this.allProducts = res;
          if(this.searchResult !== null && (res[i].category.toLowerCase().includes(this.searchResult.toLowerCase())
              || res[i].description.toLowerCase().includes(this.searchResult.toLowerCase()))) {
            this.products.push(res[i])
            this.filteredList.push(res[i])
          }
        }
      })
    }
    this.products = []
    this.filteredList = []
    // localStorage.setItem('searchStr', "")
  }

  filterByPrice(price1: number, price2: number){
    this.filteredList = [];
    for (let i = 0; i < this.products.length; i++) {
      if(price1 < this.products[i].price && price2 > this.products[i].price) {
        this.filteredList.push(this.products[i])
      }
    }
    this.products = this.filteredList;
  }

  filterByColor(color: string){
    this.filteredList = []
    for (let i = 0; i < this.products.length; i++) {
      if(this.products[i].color === color) {
        this.filteredList.push(this.products[i])
      }
    }
    this.products = this.filteredList
  }

  addToCart(name: string, price: number) {
    const userString = localStorage.getItem('user');
    if (userString && userString !== "") {
      this.user = JSON.parse(userString);
      console.log(this.user.name)
      const cartItem = {productName: name, price: price}
      console.log(cartItem)
      this.cartService.addToCart(this.user.email, cartItem).subscribe(() => {
        console.log('Item added to the cart');
        // You can handle success, update UI, etc.
      });
    }
  }

  resetBtn() {
    this.products = this.filteredList;
    this.colorOption = null
    this.priceOption = null
    this.ngOnInit()
  }

    
}
