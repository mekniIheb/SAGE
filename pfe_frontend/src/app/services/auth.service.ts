import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService  {
  private apiUrl = 'http://localhost:8088/api/auth/';

  constructor(private http: HttpClient) { }

  login(matricule: string, password: string): Observable<any> {
    return this.http.post(this.apiUrl+'signin', { matricule, password });
  }
  signup(data: any): Observable<any> {
    return this.http.post(this.apiUrl+'signup', data);
  }
}
