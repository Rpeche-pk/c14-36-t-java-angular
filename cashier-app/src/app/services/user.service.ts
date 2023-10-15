import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../interfaces/User.interface';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly API = environment.api;
  private readonly http = inject(HttpClient);

  constructor() { }

  addNewUser(user: User): Observable<any> {
    return this.http.post<any>(this.API, user)
  }

  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(this.API);
  }

  getUser(id: number): Observable<any> {
    return this.http.get<any>(`${this.API}/${id}`);
  }

  updateUser(user: User): Observable<any> {
    return this.http.put<any>(`${this.API}/${user.id}`, user)
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`)
  }
}
