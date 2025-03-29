import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PresenceService} from "../../services/presence.service";

@Component({
  selector: 'app-import-pointage',
  templateUrl: './import-pointage.component.html',
  styleUrls: ['./import-pointage.component.css']
})
export class ImportPointageComponent {
  importForm: FormGroup;
  fileName: string = '';
  message: string | null = null;
  fileErrorMessage: string | null = null; // To store file type error message
  loading: boolean = false;
  constructor(private fb: FormBuilder, private presenceUploadService: PresenceService) {
    this.importForm = this.fb.group({
      file: [null, Validators.required]
    });
  }

  // Handle file selection
  onFileChange(event: any): void {
    const file = event.target.files[0];
    const fileExtension = file?.name.split('.').pop().toLowerCase(); // Get the file extension

    if (file && fileExtension === 'xlsx') {
      this.fileName = file.name;
      this.fileErrorMessage = null; // Clear error message if valid
      this.importForm.patchValue({
        file: file
      });
    } else {
      this.fileName = '';
      this.fileErrorMessage = 'Veuillez importer uniquement des fichiers .xlsx';
      this.importForm.patchValue({
        file: null
      });
    }
  }

  // Submit the form and upload the file
  onSubmit(): void {
    if (this.importForm.valid) {
      const file = this.importForm.get('file')?.value;
      this.loading = true;
      this.presenceUploadService.uploadPresencesData(file).subscribe(
        response => {
          console.log('File uploaded successfully', response);
          this.message = 'success';
          this.loading = false;
        },
        error => {
          console.error('Error uploading file', error);
          this.message = 'error';
          this.loading = false;
        }
      );
    } else {
      this.message = 'error';
    }
  }

  // Get message text based on success or error
  getMessageText(): string {
    return this.message === 'success'
      ? 'Les pointages des employés sont ajoutés avec succès.'
      : 'Une erreur est survenue lors de l\'importation.';
  }
}
