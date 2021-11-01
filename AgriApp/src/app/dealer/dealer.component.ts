import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import jsPDF from 'jspdf';
import { cropModel } from '../models/cropModel';
import { orderModel } from '../models/Orders';
import { paymentModel } from '../models/paymentModel';
import { userModel } from '../models/userModel';
import { AdminServicesService } from '../Services/admin-services.service';
import { DealerServiceService } from '../Services/dealer-service.service';
@Component({
  selector: 'app-dealer',
  templateUrl: './dealer.component.html',
  styleUrls: ['./dealer.component.css']
})
export class DealerComponent implements OnInit {

  @ViewChild('receipt') el!:ElementRef;
  constructor(private adminService:AdminServicesService,private dealerService: DealerServiceService,private fb:FormBuilder ) { }
  searchedKeyword!: string;
  flag: boolean=false;
  paymentObj: paymentModel=new paymentModel("","","","","","");
  payObj: paymentModel=new paymentModel("","","","","","");
  payForm!:FormGroup;


currentUser:userModel=new userModel("","","","","","","");
currentFarmer:userModel=new userModel("","","","","","","");
currentCrop:cropModel=new cropModel("","","",0,"","","","");
MyOrders: orderModel[]=[];
order:orderModel=new orderModel("","","","","","","","","","");
  faCoffee = faCoffee;
  oID:number=100;
  orderId!:String;
  
  farmerList:userModel[]=[];
  CropList:cropModel[]=[];
  
  loggeduser:userModel=new userModel("","","","","","","");

  ngOnInit(): void {
    

this.loggeduser=JSON.parse(sessionStorage.loggedUser);
console.log(this.loggeduser);
this.getMyOrders();
    this.currentUser = this.adminService.currentUser;
    // console.log(this.adminService.currentUser);
    
    this.adminService.getALLCrops().subscribe(res=>{this.CropList=res});
    this.payForm=this.fb.group(

      {

        paymentAmount:[""]

      }

    )

  }

  scroll(el: HTMLElement) {
    el.scrollIntoView();
}
getFarmer(crop:cropModel){

  this.currentCrop=crop;

  this.adminService.getUserById(crop.farmerId).subscribe(res=>{

    if(res==null)

    this.currentFarmer=new userModel("","","","","","","")

    else

    this.currentFarmer=res;

  })

}
// function for getting all orders

getMyOrders() {
  this.dealerService.getMyOrders(this.loggeduser.userId).subscribe(res=>{
    this.MyOrders=res;
    console.log(this.MyOrders);
  })
}


getPrice(orderid:String){
  console.log(orderid+"printing in get price");
  
  this.dealerService.getpayment(orderid).subscribe(res=>{
    this.payObj=res;
    console.log(res+"received payment obj");
    
  })
}


placeOrder(farmerId:String,cropId:String,farmerName:String,farmerMobile:String,cropName:String){

  this.oID=this.oID+1

  this.orderId=this.loggeduser.userId + Math.random().toString(36).substr(2, 9);

  console.log((this.orderId));


  this.order= new orderModel(farmerId,this.orderId,this.loggeduser.userId,cropId,this.loggeduser.userName,

    farmerName,cropName,this.loggeduser.mobileNo,farmerMobile,"Ordered");

  this.dealerService.addOrder(this.order).subscribe(res=>{

    if(res!=null)

      alert("order Placed successfully");

  })

  this.getMyOrders();

}

payNow(porder:orderModel){
  this.order=porder;
}

addPayment(orderId:String,orderName:String,paymentTo:String,paymentFrom:String){
  console.log("in add payment");
  this.paymentObj.paymentID="P"+ Math.random().toString(36).substr(2, 9);
  this.paymentObj.orderID=orderId;
  this.paymentObj.orderName=orderName;
  this.paymentObj.paymentTo=paymentTo;
  this.paymentObj.paymentFrom=paymentFrom;
  this.paymentObj.paymentAmount=this.payForm.value.paymentAmount;
  console.log("printing in addPayment: "+this.paymentObj.orderName);
  
  this.dealerService.makePayment(this.paymentObj).subscribe(res=>{alert("Payment Successfull.")});
  this.changeOrderStatus(this.order,"Completed");
  this.getMyOrders();

}

getPDF(){

  let pdf = new jsPDF('p','pt','a4');

  pdf.html(this.el.nativeElement,{
    callback:(pdf)=>{
      pdf.save("reciept.pdf");
    }

  })
}

changeOrderStatus(order:orderModel,status:String){
  this.order.orderID=order.orderID;
  this.order.cropID=order.cropID;
  this.order.cropName=order.cropName;
  this.order.dealerID=order.dealerID;
  this.order.dealerName=order.dealerName;
  this.order.dealerMobile=order.dealerMobile;
  this.order.farmerID=order.farmerID;
  this.order.farmerName=order.farmerName;
  this.order.farmerMobile=order.farmerMobile;
  this.order.orderStatus=status;

  this.dealerService.addOrder(this.order).subscribe();

  this.getMyOrders();
}

}

