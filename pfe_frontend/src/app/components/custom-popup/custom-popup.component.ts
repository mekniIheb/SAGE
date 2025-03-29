import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-custom-popup',
  templateUrl: './custom-popup.component.html',
  styleUrls: ['./custom-popup.component.css']
})
export class CustomPopupComponent {
  @Input() message: string = '';
  @Output() close = new EventEmitter<void>();

  closePopup(): void {
    this.close.emit();
  }
}
