import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-logout-confirm-dialog',
  templateUrl: './logout-confirm-dialog.component.html',
  styleUrls: ['./logout-confirm-dialog.component.css']
})
export class LogoutConfirmDialogComponent {
  isVisible: boolean = false;

  @Output() logoutConfirmed = new EventEmitter<void>();

  open() {
    this.isVisible = true;
  }

  close() {
    this.isVisible = false;
  }

  confirmLogout() {
    this.logoutConfirmed.emit();
    this.close();
  }
}
