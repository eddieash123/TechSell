import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor() {}

  onClick(id: number) {
    switch (id) {
      case 1: 
        localStorage.setItem('searchStr', "Headphones")
        break;
      case 2: 
        localStorage.setItem('searchStr', "Cell Phones")
        break;
      case 3: 
        localStorage.setItem('searchStr', "TVs")
        break;
      case 4: 
        localStorage.setItem('searchStr', "Tablets")
        break;
      case 5: 
        localStorage.setItem('searchStr', "Laptops")
        break;
      case 6: 
        localStorage.setItem('searchStr', "Accessories")
        break;
      default:
        localStorage.setItem('searchStr', "Products")
        break;
    }
  }

}
