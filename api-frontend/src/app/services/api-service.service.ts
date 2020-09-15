import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from '../model/item.model';
import { ApiMain } from '../api.main';
import { Observable, from, observable } from 'rxjs';
import { HTTPResponse } from '../model/HTTPResponse';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {


    apiConfig: ApiMain;

  constructor(private http: HttpClient) {
    this.apiConfig = new ApiMain();
  }

  getAllItems(); : observable<Item[]>{
    return this.http.get(this.apiConfig.getApiUrl('items/getAllItems/')) as Observable<Item[]>;
  };

}




