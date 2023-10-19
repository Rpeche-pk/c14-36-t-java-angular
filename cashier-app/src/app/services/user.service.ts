import { HttpClient, HttpHeaders,  } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../interfaces/User.interface';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly API = environment.api;
  private readonly API2 = environment.api2;
  private readonly http = inject(HttpClient);

  constructor() {}

  addNewUser(user: User): Observable<User> {
    return this.http.post<User>(this.API, user);
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.API2);
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>(`${this.API}/${id}`);
  }

  updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.API}/${user.id}`, user);
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }
  loginUser(user: User): Observable<any> {
    const token =
      'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2OTc2NDEwMzQsImlzcyI6ImNhc2hpZXIiLCJkYXRhIjp7InN1YiI6InJhdWxAZ21haWwuY29tIiwicm9sZSI6IlJPTEVfVVNFUiIsInBob25lIjoiMjYxNjU1NTY1IiwibmFtZSI6IlJhdWwgR29tZXoifX0.9kHRR46Gdo6t7GaxXMbvcheLaXXE-jFVM2pGxb_5Smg';

    const httpOptions:any = {
      Headers: new HttpHeaders({
        'Authorization': `Bearer ${token}`
      })
    }
    console.log(httpOptions);
    console.log(user);

    return this.http.get<Observable<any>>(this.API, httpOptions);
  }
}
