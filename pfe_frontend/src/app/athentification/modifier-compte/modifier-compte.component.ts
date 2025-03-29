import {Component, OnInit} from '@angular/core';
import {StorageService} from "../../services/storage.service";
import {EmployeService} from "../../services/employe.service";
import {Employe} from "../../models/employe.model";
import {CompteService} from "../../services/compte.service";
import {Compte} from "../../models/compte.model";

@Component({
  selector: 'app-modifier-compte',
  templateUrl: './modifier-compte.component.html',
  styleUrls: ['./modifier-compte.component.css']
})
export class ModifierCompteComponent implements OnInit {
  currentUser: any;
  matricule: any;
  employe: Employe | undefined;
  compte: Compte | undefined;
  idCompte: any;
  showPopup: boolean = false;
  popupMessage: string = '';

  constructor(private storageService: StorageService,
              private employeService: EmployeService,
              private compteService: CompteService
  ) {
  }

  ngOnInit()
    :
    void {
    this.currentUser = this.storageService.getUser();
    console.log("user :" + this.currentUser)
    this.matricule = this.currentUser.matricule;
    this.idCompte = this.currentUser.id
    this.getEmployeByMatricule()
    this.getCompteById()
  }

  user = {
    name: '',
    email: '',
    department: '',
    telephone: '',
    password: ''
  };

  getCompteById(): void {
    if (this.idCompte) {
      this.compteService.getCompteById(this.idCompte).subscribe({
        next: (response: Compte) => {
          this.compte = response
          this.user.email = this.compte.email
          this.user.password = this.compte.password
        },
        error: (error) => {
          console.error(error);
        }
      });
    } else {
    }
  }

  getEmployeByMatricule(): void {
    if (this.matricule) {
      this.employeService.getEmployeByMatricule(this.matricule).subscribe({
        next: (response: Employe) => {
          this.employe = response;
          // Patch the values to the user object
          this.user.name = this.employe.name;
          this.user.department = this.employe.departement;
          this.user.telephone = this.employe.telephone;
        },
        error: (error) => {
          console.error(error);
        }
      });
    } else {
    }
  }

  onSubmit(): void {
    if (this.employe) {
      // Update the employe object with the new values from the form
      this.employe.name = this.user.name;
      this.employe.telephone = this.user.telephone;

      // Call the service to update the employee details
      this.employeService.updateEmploye(this.employe).subscribe({
        next: (response) => {
          console.log("Employee updated successfully", response);
          this.showPopupMessage('Employee updated successfully!');
        },
        error: (error) => {
          console.error("Error updating employee", error);
          // Handle error, maybe show an error message
        }
      });

    }
    if (this.compte) {
      this.compte.email = this.user.email
      this.compteService.updateCompte(this.compte).subscribe({
        next: (response) => {

          console.log("Compte updated successfully", response);
          this.showPopupMessage('Compte updated successfully!');
        },
        error: (error) => {
          console.error("Error updating Compte", error);
          // Handle error, maybe show an error message
        }
      })
    }
  }

  showPopupMessage(message: string): void {
    this.popupMessage = message;
    this.showPopup = true;
  }
}
