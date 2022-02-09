import { Component, OnInit } from '@angular/core';
import { Customer } from './domain/customer';
import { PhoneNumbersService } from './services/phone-numbers.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  countries: string[] = ['Cameroon', 'Ethiopia', 'Morocco', 'Mozambique', 'Uganda'];
  states: string[] = ['Valid', 'Not valid'];
  selectedCountry = '';
  selectedState = '';
  customers: Customer[] = [];

  constructor(private phoneNumbersService: PhoneNumbersService) { }
  
  ngOnInit(): void {
    this.search();
  }

  search(): void {
    this.phoneNumbersService.findByFilters(this.selectedCountry, this.selectedState).subscribe({
      next: (data) => this.customers = data,
      error: (error) => console.log(error)
    });
  }

}