import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CanActivate, CanActivateChildFn, Route, Router } from '@angular/router';
import { UserRole } from '../models/UserRole';
import { Users } from '../models/Users';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginObj: any = {
    "email": "",
    "password" : ""
  }

  userLoggedIn: Users = {
    id: -1,
    name: '',
    email: '',
    password: '',
    userRole: UserRole.USER,
    locked: false,
    enabled: true
  }

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit() {
    localStorage.setItem('user', "")
  }

  onLogin() {
    this.http.post<any>(`http://localhost:8080/users/login/${this.loginObj.email}/${this.loginObj.password}`, this.loginObj)
      .subscribe((res) => {
        if(res.result) {
          localStorage.setItem('user', JSON.stringify(res.user))
          this.router.navigateByUrl("/home");
        } else {
          alert("Invalid Credentials")
        }
      });
  }
}
