import { Component } from '@angular/core';

@Component({
  selector: 'app-consult-remplacent',
  templateUrl: './consult-remplacent.component.html',
  styleUrls: ['./consult-remplacent.component.css']
})
export class ConsultRemplacentComponent {
  date: string = '';
  replacementsData: any[] = []; // This will hold the data for the table

  constructor() { }

  filterModifierRemplacentData() {
    console.log('Fetching data for:', this.date);
    // Replace with actual service call to fetch data based on the selected date
    // this.replacementsData = fetchedData; // Update with actual fetched data
  }
}
