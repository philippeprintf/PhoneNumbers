import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../domain/customer';
import { Constants } from '../util/constants';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private url = Constants.backendUrl + 'v1/customer/';

  constructor(private httpClient: HttpClient) { }

  findByFilters(countryName: string, phoneNumberState: string): Observable<Customer[]> {
    let httpParams = new HttpParams();
    httpParams = httpParams.append('countryName', countryName);
    httpParams = httpParams.append('phoneNumberState', phoneNumberState);
    return this.httpClient.get<Customer[]>(this.url + 'findByFilters', {params: httpParams});
  }
}
