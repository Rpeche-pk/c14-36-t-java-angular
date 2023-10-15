import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interfaces/User.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly API = 'user.json'
  private readonly http = inject(HttpClient);

  constructor() { }

  addNewUser(user: User): Observable<User> {
    return this.http.post<User>(this.API, user);
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.API);
  }

  getUser(id: string): Observable<User> {
    return this.http.get<User>(`${this.API}/${id}`);
  }

  updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.API}/${user.id}`, user)
  }

  deleteUser(id: string): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`)
  }
}
