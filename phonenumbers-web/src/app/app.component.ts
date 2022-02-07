import { Component, OnInit } from '@angular/core';
import { Customer } from './domain/customer';
import { PhoneNumbersService } from './serivces/phone-numbers.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  customers: Customer[] = [];

  constructor(private phoneNumbersService: PhoneNumbersService) { }
  
  ngOnInit(): void {
    this.phoneNumbersService.findByFilters('', '').subscribe({
      next: (data) => this.customers = data,
      error: (error) => console.log(error)
    });
  }

}
