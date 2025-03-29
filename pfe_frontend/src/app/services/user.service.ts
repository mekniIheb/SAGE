import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'https://your-backend-api.com/user-info'; // Replace with your backend API URL

  constructor(private http: HttpClient) {}

  // Fetch user info from the API
  getUserInfo(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
