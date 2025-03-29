import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Employe} from "../models/employe.model";
import {Page} from "../models/page.model";

@Injectable({
  providedIn: 'root'
})
export class EmployeService {
  private apiUrl = 'http://localhost:8088/api/employes';
  constructor(private http: HttpClient) { }

  // Save or create a new employee
  saveEmploye(employe: Employe): Observable<Employe> {
    return this.http.post<Employe>(`${this.apiUrl}/save`, employe);
  }

  // Get all employees with pagination
  getAllEmployesPaged(page: number = 0, size: number = 10): Observable<Page<Employe>> {
    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    return this.http.get<Page<Employe>>(`${this.apiUrl}/all`, { params });
  }

  // Get a specific employee by matricule
  getEmployeByMatricule(matricule: number): Observable<Employe> {
    return this.http.get<Employe>(`${this.apiUrl}/${matricule}`);
  }

  // Delete an employee by matricule
  deleteEmploye(matricule: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${matricule}`);
  }
  updateEmploye(employe: Employe): Observable<Employe> {
    const url = `${this.apiUrl}/update-profile`; // Assuming matricule is used as an identifier
    return this.http.put<Employe>(url, employe);
  }
}
