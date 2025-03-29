import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employe} from "../models/employe.model";
import {Compte} from "../models/compte.model";

@Injectable({
  providedIn: 'root'
})

export class CompteService {
  private apiUrl = 'http://localhost:8088/api/comptes';
  constructor(private http: HttpClient) { }
  getCompteById(id: number): Observable<Compte> {
    return this.http.get<Compte>(`${this.apiUrl}/${id}`);
  }

  updateCompte(compteDto: Compte | undefined): Observable<Compte> {
    const url = `${this.apiUrl}/update`;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put<Compte>(url, compteDto, { headers });
  }
  updatePassword(id: number, currentPassword: string, newPassword: string): Observable<any> {
    const body = {
      currentPassword: currentPassword,
      newPassword: newPassword
    };
    return this.http.put(`${this.apiUrl}/update-password/${id}`, body);
  }
}
