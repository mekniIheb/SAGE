import { Component } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  signupForm: FormGroup;
  errorMessage: string = '';
  showPassword: boolean = false;
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.signupForm = this.fb.group({
      matricule: ['', [Validators.required, Validators.min(1)]],
      email: ['', [Validators.email]],
      password: ['', [Validators.required]],
      confirmPassword: ['', [Validators.required]],
      role: ['', [Validators.required]]
    }, { validator: this.passwordsMatchValidator });
  }
  togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }
  passwordsMatchValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;
    if (password !== confirmPassword) {
      return { passwordsMismatch: true };
    }
    return null;
  }
  onSubmit() {
    console.log("Form Value:", this.signupForm.value); // Better logging
    if (this.signupForm.valid) {
      this.authService.signup(this.signupForm.value).subscribe({
        next: (response) => {
          // handle successful registration
          this.router.navigate(['/login']);
        },
        error: (error) => {
          console.error("Registration Error:", error);
          if (error.error && error.error.message) {
            this.errorMessage = error.error.message;
          } else {
            this.errorMessage = error.error;
          }
        }
      });
    } else {
      this.errorMessage = 'Veuillez remplir tous les champs obligatoires.';
    }
  }
  // Utility methods to get form control error states
  get matricule() {
    return this.signupForm.get('matricule');
  }

  get email() {
    return this.signupForm.get('email');
  }

  get password() {
    return this.signupForm.get('password');
  }

  get role() {
    return this.signupForm.get('role');
  }
  get confirmPassword() {
    return this.signupForm.get('confirmPassword');
  }
}
