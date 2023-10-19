import { Component } from '@angular/core';

@Component({
  selector: 'app-found404',
  templateUrl: './found404.component.html',
  styleUrls: ['./found404.component.scss']
})
export class Found404Component {
  hasToken = false;
  constructor(){
    this.hasToken = localStorage.getItem('token') !== null;
  }
}
