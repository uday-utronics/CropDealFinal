import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { cropModel } from '../models/cropModel';

@Injectable({
  providedIn: 'root'
})
export class FarmerService {

  constructor(private http:HttpClient) { }
  getMyCrops(farmerId:String){



    return this.http.get<cropModel[]>("http://localhost:8084/crop/getall/"+farmerId);

  }
}
