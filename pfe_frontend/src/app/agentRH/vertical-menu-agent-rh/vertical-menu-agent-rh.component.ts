import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {StorageService} from "../../services/storage.service";
import {EmployeService} from "../../services/employe.service";
import {Employe} from "../../models/employe.model";

@Component({
  selector: 'app-vertical-menu-agent-rh',
  templateUrl: './vertical-menu-agent-rh.component.html',
  styleUrls: ['./vertical-menu-agent-rh.component.css']
})
export class VerticalMenuAgentRhComponent implements OnInit {
  userName: string = '';
  userType: string = '';
  currentUser: any;
  matricule: any;
  employe: Employe | undefined;
  errorMessage: string = '';
  constructor(private storageService: StorageService, private employeService: EmployeService) {}

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
          this.userType=this.currentUser.role
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
  getUserData() {
    /*// Fetching user data from a service or backend
    this.userService.getUserInfo().subscribe((data: any) => {
      this.userName = data.name;
      this.userType = data.type;
    });*/
  }
}
