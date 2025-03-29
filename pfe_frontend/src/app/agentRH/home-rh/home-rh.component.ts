import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-home-rh',
  templateUrl: './home-rh.component.html',
  styleUrls: ['./home-rh.component.css']
})
export class HomeRhComponent implements OnInit{
  currentDate: Date | undefined;

  constructor() { }

  ngOnInit(): void {
    this.currentDate = new Date();
  }
}
