import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Constants } from "../util/constants";

@Injectable({
    providedIn: 'root'
  })
  export class CountryService {
  
    private url = Constants.backendUrl + 'v1/country/';
  
    constructor(private httpClient: HttpClient) { }
  
    getCountryNameList(): Observable<string[]> {
      return this.httpClient.get<string[]>(this.url + 'getCountryNameList');
    }
  }