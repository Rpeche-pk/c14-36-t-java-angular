import { Injectable, OnInit, inject } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { UserData } from '../interfaces/userData.inteface';
@Injectable({
  providedIn: 'root'
})
export class TokenService {

  UserData!: UserData;

  constructor() {
    window.addEventListener('storage', () => {
      this.tokenStatus.next(this.hasToken())
    })
  }
  

  private tokenStatus = new BehaviorSubject<boolean>(this.hasToken());

  public hasToken() {
    return localStorage.getItem('tokenCashier') !== null;
  }

  watchToken() {
    return this.tokenStatus.asObservable();
  }
  getTokenDecoded(): any {
    const token = localStorage.getItem('tokenCashier');
    let decodeToken;
    if (token) {
      const helper = new JwtHelperService();
      decodeToken = helper.decodeToken(token);

      return decodeToken;
    } else {
      return null;
    }
    this.UserData = decodeToken;
  }
}
