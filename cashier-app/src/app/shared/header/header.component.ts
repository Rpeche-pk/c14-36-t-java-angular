import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserData } from 'src/app/interfaces/userData.inteface';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  constructor(private route: Router) { }

  ngOnInit(): void {

  }

  logOutUser() {
    /* logica del servicio */
    localStorage.clear();
    this.route.navigate(["login"])
  }
}
