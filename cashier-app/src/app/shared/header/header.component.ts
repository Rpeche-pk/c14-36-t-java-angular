<<<<<<< HEAD
import { Component } from '@angular/core';
=======
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { UserData } from 'src/app/interfaces/userData.inteface';
>>>>>>> 136f9d0fec4717902ec63fa825dbc4be3b5e647c

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
<<<<<<< HEAD

=======
  @Input() userData!:UserData;
  constructor(private route: Router) { }

  ngOnInit(): void {

  }
  pipeNameData(name:string){
    const names = name.split(" ");
    const [firstName, lastname] = names;
    return (firstName.charAt(0)+lastname.charAt(0)).toUpperCase();
  }
  logOutUser() {
    /* logica del servicio */
    localStorage.clear();
    this.route.navigate(["login"])
  }
>>>>>>> 136f9d0fec4717902ec63fa825dbc4be3b5e647c
}
