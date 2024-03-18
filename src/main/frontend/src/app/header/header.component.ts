import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  
  searchString: string = ""
  isLoggedIn:boolean = false;
  user: any;

  constructor(private router: Router) {}

  ngOnInit() {
    const userString = localStorage.getItem('user');

    if (userString && userString !== "") {
      this.isLoggedIn = true;
      this.user = JSON.parse(userString);
    }
  }

  onEnterKeyPressed(){
    if(this.searchString !== "") {
      localStorage.setItem('searchStr', this.searchString)
      this.router.navigate(['/products'])
      if(this.router.url === "/products") { //only reloads the page if im already on products page
        window.location.reload() 
      } 
    }
  }

  productSearch(product: string) {
    localStorage.setItem('searchStr', product)
    this.router.navigate(['/products'])
    if(this.router.url === "/products") { //only reloads the page if im already on products page
      window.location.reload() 
    } 
  }

  
}
