import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PresenceService} from "../../../services/presence.service";

@Component({
  selector: 'app-verification-presence',
  templateUrl: './verification-presence.component.html',
  styleUrls: ['./verification-presence.component.css']
})
export class VerificationPresenceComponent {
  dateForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.dateForm = this.fb.group({
      debut: ['', Validators.required],
      fin: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.dateForm.valid) {
      console.log('Form Data:', this.dateForm.value);
      // Add HTTP call here to submit the form data
    }
  }
}
