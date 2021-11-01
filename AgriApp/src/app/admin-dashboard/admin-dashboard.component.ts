import { Component, OnInit, ViewChild } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { AdminServicesService } from '../Services/admin-services.service';
import { userModel } from '../models/userModel';
import { Subject } from 'rxjs';
import { DataTableDirective } from 'angular-datatables';
import { cropModel } from '../models/cropModel';
import { MatPaginator } from '@angular/material/paginator';
import { FormBuilder, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit{
 
  // dtOptions: DataTables.Settings = {};
  // dtTrigger: Subject<any> = new Subject();
  //dtElement: DataTableDirective;
  // dtOptions: DataTables.Settings = {};
  // dtTrigger: Subject<any> = new Subject();
  //dtElement: DataTableDirective;


  displayedColumns: string[] = ['farmerId', 'cropId', 'cropName', 'cropQty','cropType','cropPrice','cropDesc','cropImgUrl','Actions'];
  dataSource:any;

  formValue!:FormGroup;
  formValueCrop!:FormGroup;
  cropObj : cropModel = new cropModel("","","",0,"","","","");

  FarmerList:userModel[]=[];
  DealerList:userModel[]=[];
  userObj : userModel = new userModel("","","","","","","");
  CropList:cropModel[]=[];
  result:any;
  
  constructor(private breakpointObserver: BreakpointObserver, private adminService:AdminServicesService, private fb:FormBuilder) {}


  ngOnInit(): void {

    // this.dtOptions = {
    //   pagingType: 'full_numbers',
    //   pageLength: 5,
    //   processing: true,
    //   lengthMenu:[[5,10,20,25,50,-1],[5,10,20,25,50,"All"]]
    // };
    
    // this.adminService.getALLFarmers().subscribe(res=>{this.FarmerList=res});
    // this.adminService.getALLDealers().subscribe(res=>{this.DealerList=res});
    // this.adminService.getALLCrops().subscribe(res=>{this.CropList=res});
    this.getEverything();
    console.log(this.FarmerList.length);
    







    this.formValue=this.fb.group(
      {
        userName:[""],
        userEmail:[""],
        userId:[""],
        location:[""],
        accountNo:[""],
        mobileNo:[""],
        userType:[""],
        password:[""]
      }
    )

    this.formValueCrop=this.fb.group(
      {
        farmerId:[""],
        cropId:[""],
        cropName:[""],
        cropQty:[""],
        cropType:[""],
        cropPrice:[""],
        cropDesc:[""],
        cropImgUrl:[""]
      }
    )
    
  }


  addUser(){
    console.log("in add user method");
    this.userObj.userName=this.formValue.value.userName;
    this.userObj.location=this.formValue.value.location;
    this.userObj.mobileNo=this.formValue.value.mobileNo;
    this.userObj.userType=this.formValue.value.userType;
    this.userObj.userEmail=this.formValue.value.userEmail;
    this.userObj.password=this.formValue.value.password;

    if(this.userObj.userType=="Farmer"){
      this.adminService.Adduser(this.userObj).subscribe(res=>{this.FarmerList.push(res)});
      console.log("user Added successfully");
      
    }
    else if(this.userObj.userType=="Dealer"){
      this.adminService.Adduser(this.userObj).subscribe(res=>{this.DealerList.push(res)});
      console.log("user Added successfully");
    }
    else
    alert("wrong UserType");
    
    this.getEverything();
    this.formValue.reset();
    this.ngOnInit();
  }

 
  editUser(data:any){
    this.userObj.userId=data.userId;
    this.formValue.controls['userName'].setValue(data.userName);
    this.formValue.controls['userEmail'].setValue(data.userEmail);
    this.formValue.controls['location'].setValue(data.location);
    this.formValue.controls['mobileNo'].setValue(data.mobileNo);
    this.formValue.controls['userType'].setValue(data.userType);
    this.formValue.controls['password'].setValue(data.password);
    
  }
  updateUser(){
    this.userObj.userName=this.formValue.value.userName;
    this.userObj.location=this.formValue.value.location;
    this.userObj.mobileNo=this.formValue.value.mobileNo;
    this.userObj.userType=this.formValue.value.userType;
    this.userObj.userEmail=this.formValue.value.userEmail;
    this.userObj.password=this.formValue.value.password;
    this.adminService.updateUser(this.userObj,this.userObj.userId).subscribe(res=>{
      console.log("updated user successfully")
    });
    
    this.getEverything();
    this.ngOnInit();
    this.formValue.reset();
    
    
  }

  deleteFarmer(userId:String){
    
    // console.log("in delete method")
    this.adminService.DeleteFarmer(userId).subscribe(res=>{this.result=res});
  //  console.log("deleted User")
  this.getEverything();
  this.ngOnInit();
    
    
  }

  getEverything(){
    this.adminService.getALLCrops().subscribe(res => { this.CropList = res });
    this.adminService.getALLFarmers().subscribe(res => { this.FarmerList = res }); 
    this.adminService.getALLDealers().subscribe(res => { this.DealerList = res });
  
  }

  // ------------------------------------------------------
  addCrop(){
    console.log("in add crop method");
    this.cropObj.cropId=this.formValueCrop.value.cropId;
    this.cropObj.cropName=this.formValueCrop.value.cropName;
    this.cropObj.cropPrice=this.formValueCrop.value.cropPrice;
    this.cropObj.cropQty=this.formValueCrop.value.cropQty;
    this.cropObj.farmerId=this.formValueCrop.value.farmerId;
    this.cropObj.cropType=this.formValueCrop.value.cropType;
    this.cropObj.cropDesc=this.formValueCrop.value.cropDesc;
    this.cropObj.cropImgUrl=this.formValueCrop.value.cropImgUrl;
    if(this.cropObj!=null){
      this.adminService.Addcrop(this.cropObj).subscribe(res=>{this.CropList.push(res)});
    }
    this.getEverything();
    this.ngOnInit();
    
  }

  editCrop(data:any){
    console.log(data);
    
    this.cropObj.farmerId=data.farmerId;
    this.formValueCrop.controls['farmerId'].setValue(data.farmerId);
    this.formValueCrop.controls['cropId'].setValue(data.cropId);
    this.formValueCrop.controls['cropName'].setValue(data.cropName);
    this.formValueCrop.controls['cropQty'].setValue(data.cropQty);
    this.formValueCrop.controls['cropType'].setValue(data.cropType);
    this.formValueCrop.controls['cropPrice'].setValue(data.cropPrice);
    this.formValueCrop.controls['cropDesc'].setValue(data.cropDesc);
    this.formValueCrop.controls['cropImgUrl'].setValue(data.cropImgUrl);
    
  }

  updateCrop(){
    this.cropObj.farmerId=this.formValueCrop.value.farmerId;
    this.cropObj.cropId=this.formValueCrop.value.cropId;
    this.cropObj.cropName=this.formValueCrop.value.cropName;
    this.cropObj.cropQty=this.formValueCrop.value.cropQty;
    this.cropObj.cropType=this.formValueCrop.value.cropType;
    this.cropObj.cropPrice=this.formValueCrop.value.cropPrice;
    this.cropObj.cropDesc=this.formValueCrop.value.cropDesc;
    this.cropObj.cropImgUrl=this.formValueCrop.value.cropImgUrl;

    this.adminService.updateCrop(this.cropObj).subscribe(res=>{
      console.log("updated crop succesfully")
      
    });
    this.getEverything();
    this.ngOnInit();
  }

  deleteCrop(cropId:string){
    this.adminService.DeleteCrop(cropId).subscribe(res=>{this.result=res});
    console.log("deleted crop");

    this.getEverything();
    this.ngOnInit();
    
  }
}
