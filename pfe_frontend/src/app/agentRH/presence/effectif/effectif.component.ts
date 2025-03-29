import { Component } from '@angular/core';

@Component({
  selector: 'app-effectif',
  templateUrl: './effectif.component.html',
  styleUrls: ['./effectif.component.css']
})
export class EffectifComponent {
  date: string = '';
  shift: number | null = null;
  data: any[] = []; // This will hold the data for the table

  constructor() { }

  filterConsulterEffectif() {
    // Call your service to get data based on date and shift
    console.log('Fetching data for:', this.date, this.shift);
    // Simulated fetch logic here (replace with actual service call)
    // this.data = fetchedData; // Update with actual fetched data
  }
}
