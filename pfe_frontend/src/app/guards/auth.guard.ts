import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {StorageService} from "../services/storage.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private storageService: StorageService, private router: Router) {
  }
  canActivate(): boolean {
    if (this.storageService.isLoggedIn()) {
      // If the user is logged in, allow access to the route
      return true;
    } else {
      // If the user is not logged in, redirect them to the login page
      this.router.navigate(['/login']);
      return false;
    }
  }

}
