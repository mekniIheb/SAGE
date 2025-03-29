import {Component, OnInit} from '@angular/core';
import {StorageService} from "../../services/storage.service";
import {Employe} from "../../models/employe.model";
import {EmployeService} from "../../services/employe.service";
import {
  LogoutConfirmDialogComponent
} from "../../athentification/logout-confirm-dialog/logout-confirm-dialog.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-horizontal-menu-agent-rh',
  templateUrl: './horizontal-menu-agent-rh.component.html',
  styleUrls: ['./horizontal-menu-agent-rh.component.css']
})
export class HorizontalMenuAgentRhComponent implements OnInit {
  userName: string = '';
  searchQuery: string = '';
  currentUser: any;
  matricule: any;
  employe: Employe | undefined;
  errorMessage: string = '';

  constructor(private storageService: StorageService,
              private employeService: EmployeService,
              private router :Router) {
  }

  ngOnInit(): void {
    this.currentUser = this.storageService.getUser();
    this.matricule = this.currentUser.matricule;
    this.getEmployeByMatricule();
  }

  getEmployeByMatricule(): void {
    if (this.matricule) {
      this.employeService.getEmployeByMatricule(this.matricule).subscribe({
        next: (response: Employe) => {
          this.employe = response;
          this.userName=this.employe.name
          console.log("employee:" + this.employe)
        },
        error: (error) => {
          this.errorMessage = 'Error fetching employee details.';
          console.error(error);
        }
      });
    } else {
      this.errorMessage = 'Matricule not found.';
    }
  }

  onSearch() {
    console.log('Searching for:', this.searchQuery);
    // Handle search logic
  }

  logout(): void {
    window.sessionStorage.clear();
    this.router.navigate(['login'])
  }


  toggleMenu() {
    console.log('Toggling menu');
    // Logic to toggle side menu
  }

  toggleFullScreen() {
    const doc = document as any;
    if (!doc.fullscreenElement) {
      doc.documentElement.requestFullscreen();
    } else if (doc.exitFullscreen) {
      doc.exitFullscreen();
    }
  }

  toggleOffcanvas() {
    console.log('Toggling offcanvas');
    // Logic to toggle offcanvas menu for mobile devices
  }
}
