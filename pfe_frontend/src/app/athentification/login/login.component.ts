import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {StorageService} from "../../services/storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginForm: FormGroup;
  errorMessage: string = '';
  isLoggedIn = false;
  showPassword: boolean = false;
  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router,
              private storageService: StorageService) {
    this.loginForm = this.fb.group({
      matricule: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }
  togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }
  onSubmit() {
    // Reset the error message each time the form is submitted
    this.errorMessage = '';

    if (this.loginForm.valid) {
      const { matricule, password } = this.loginForm.value;
      this.authService.login(matricule, password).subscribe({
        next: (response) => {
          this.storageService.saveUser(response);
          this.router.navigate(['/home-rh']);
        },
        error: (error) => {
          // Check for specific error messages returned from the backend
          if (error.error) {
            if (error.error.message === 'erreur_password') {
              this.errorMessage = 'Le mot de passe que vous avez entré est incorrect.';
            } else if (error.error.message === 'error_number_user') {
              this.errorMessage = 'Nous n\'avons pas trouvé le matricule saisi dans notre système informatique.';
            } else {
              this.errorMessage = 'Une erreur est survenue, veuillez réessayer.';
            }
          } else {
            // Handle unexpected errors
            this.errorMessage = 'Une erreur est survenue, veuillez réessayer.';
          }
        }
      });
    } else {
      this.errorMessage = 'Veuillez remplir tous les champs requis.';
    }
  }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;

    }
  }
  get matricule() {
    return this.loginForm.get('matricule');
  }

  get password() {
    return this.loginForm.get('password');
  }
}
