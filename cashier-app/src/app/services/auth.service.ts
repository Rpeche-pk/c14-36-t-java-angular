import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:9698/v1/api/login/';

  constructor(private http: HttpClient) {}

  login(body: FormGroup<any>, token: string): Observable<any> {
    const body:FormGroup<any> = {
      body.email,
      body.password
    };

    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });

    return this.http.post<any>(this.apiUrl, body, { headers });
  }
}
