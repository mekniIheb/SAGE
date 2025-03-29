import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class PresenceService {

  private apiUrl = 'http://localhost:8088/api/presences/upload-presences-data';

  constructor(private http: HttpClient) {}

  // Upload presence data (file) to the server
  uploadPresencesData(file: File): Observable<any> {
    const formData = new FormData();
    formData.append('file', file);  // Append the file to form data

    // Post request to upload the file
    return this.http.post<any>(this.apiUrl, formData, {
      headers: new HttpHeaders({
        'Accept': 'application/json'  // Accept JSON response
      })
    }).pipe(
      catchError(this.handleError)  // Error handling
    );
  }

  // Handle errors from the API
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      console.error('Client-side error:', error.error.message);
    } else {
      // Server-side error
      console.error(`Server error code: ${error.status}, ` + `error body: ${error.error}`);
    }
    return throwError('An error occurred while uploading the file. Please try again later.');
  }
}
