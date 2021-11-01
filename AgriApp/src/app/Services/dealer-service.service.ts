import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { orderModel } from '../models/Orders';
import { paymentModel } from '../models/paymentModel';

@Injectable({
  providedIn: 'root'
})
export class DealerServiceService {

  constructor(private http:HttpClient) { }

  public getMyOrders(dealerID:String){
    return this.http.get<orderModel[]>("http://localhost:8087/getOrderByDealer/"+dealerID);
  }

  public getFarmerOrders(farmerID:String){
    return this.http.get<orderModel[]>("http://localhost:8087/getOrderByFarmer/"+farmerID);
  }

  public makePayment(payment:paymentModel){
    return this.http.post("http://localhost:8090/addPayment",payment);
  }


  public getpayment(orderid:String){
    return this.http.get<paymentModel>("http://localhost:8090/getByPaymentId/"+orderid);
  }


  public addOrder(order:orderModel){
    return this.http.post("http://localhost:8087/addOrder",order);
  }
}