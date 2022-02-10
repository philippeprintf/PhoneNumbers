import { Component, OnInit } from '@angular/core';
import { Customer } from './domain/customer';
import { CountryService } from './services/country.service';
import { CustomerService } from './services/customer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  countries: string[] = [];
  states: string[] = [];
  selectedCountry = '';
  selectedState = '';
  customers: Customer[] = [];

  constructor(
    private customerService: CustomerService,
    private countryService: CountryService
    ) { }
  
  ngOnInit(): void {
    this.loadFilters();
    this.search();
  }

  private loadFilters(): void {

    this.countryService.getCountryNameList().subscribe({
      next: (data) => this.countries = data,
      error: (error) => console.log(error)
    });

    this.states = ['Valid', 'Not valid'];
    
  }

  search(): void {
    this.customerService.findByFilters(this.selectedCountry, this.selectedState).subscribe({
      next: (data) => this.customers = data,
      error: (error) => console.log(error)
    });
  }

  clear(): void {
    this.selectedCountry = '';
    this.selectedState = '';
  }

}
