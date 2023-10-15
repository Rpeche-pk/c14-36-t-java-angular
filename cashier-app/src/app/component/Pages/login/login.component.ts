import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(private router:Router){}

  toRegist(){
    this.router.navigate(["register"])
  }
  login(){
    /* logica de auth */
    this.router.navigate(['user'])
  }
}
