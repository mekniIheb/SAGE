import { Component } from '@angular/core';
import {CompteService} from "../../services/compte.service";

@Component({
  selector: 'app-modifier-password',
  templateUrl: './modifier-password.component.html',
  styleUrls: ['./modifier-password.component.css']
})
export class ModifierPasswordComponent {
  user = {
    currentPassword: '',
    newPassword: '',
    confirmPassword: ''
  };

  constructor(private passwordService: CompteService) { }

  onSubmit(): void {
    if (this.user.newPassword === this.user.confirmPassword) {
      this.passwordService.updatePassword(1,this.user.currentPassword, this.user.newPassword).subscribe({
        next: (response) => {
          console.log('Password updated successfully', response);
          // Handle success, maybe show a success message or reset the form
        },
        error: (error) => {
          console.error('Error updating password', error);
          // Handle error, maybe show an error message
        }
      });
    } else {
      console.error('Passwords do not match');
    }
  }
}
