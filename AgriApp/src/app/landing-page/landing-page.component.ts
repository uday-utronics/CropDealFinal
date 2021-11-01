import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { data } from 'jquery';
import { ToastrService } from 'ngx-toastr';


import { userModel } from '../models/userModel';
import { AdminServicesService } from '../Services/admin-services.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  //data:userModel= new userModel("","","","","","","");
  loginUser:userModel=new userModel("","","","","","","");
  currentUser:userModel=new userModel("","","","","","","");
  userObj: userModel = new userModel("", "", "", "", "", "", "");
  formValue!:FormGroup;
  signUpForm!: FormGroup;


  message!: string;
  flag:Boolean = true;
  @Output() newItemEvent = new EventEmitter();
  loginForm!:FormGroup;
  
  
  constructor( private fb:FormBuilder, private service:AdminServicesService,private router:Router,private toastr:ToastrService) { }

  ngOnInit(): void {

    this.signUpForm = this.fb.group(

      {

        userName: [""],
        userEmail: [""],
        userId: [""],
        location: [""],
        accountNo: [""],
        mobileNo: [""],
        userType: [""],
        password: [""]

      }

    )


    this.loginForm=this.fb.group(
      {
        userName:[""],
        password:[""],
      }
    )
      sessionStorage.removeItem('loggedUser');

  }

  changeParentUser(){
    this.newItemEvent.emit();
  }
  Authenticate(){

    console.log("in authentication function");
    
    //console.log(this.loginForm.value.userName);
    
    this.currentUser.userName=this.loginForm.value.userName;
    this.currentUser.password=this.loginForm.value.password;

    this.service.authenticateUser(this.currentUser).subscribe(res=>{
      this.loginUser = res;
      this.validateUser(res);
  }
    );
    //console.log(this.service.currentUser);
    
    // console.log("usertype: "+this.currentUser.userType);
    //this.loginForm.reset();
  }


  validateUser(user:any){
    console.log("in validate user function "+user)
    if(user==null){
      this.message="Invalid username and password";
    }
    if(user.password==this.loginForm.value.password){
      
      sessionStorage.setItem('loggedUser', JSON.stringify(user));
      if(user.userType=="Dealer"){
        

        // sessionStorage.setItem("loggedUser",user.userName);
        
        // this.service.currentUser=user;
        console.log("currentUser updated : "+user.location);
        
        this.router.navigate(['/dealer'])
        
      }
      else if(user.userType=="Admin"){
        this.router.navigate(['/admin'])
      }

      else if(user.userType=="Farmer"){
        this.router.navigate(['/farmer'])
      }

    }

  }
  addUser() {

    console.log("in add user method");

    this.userObj.userName = this.signUpForm.value.userName;

    this.userObj.location = this.signUpForm.value.location;

    this.userObj.mobileNo = this.signUpForm.value.mobileNo;

    this.userObj.userType = this.signUpForm.value.userType;

    this.userObj.userEmail = this.signUpForm.value.userEmail;

    this.userObj.password = this.signUpForm.value.password;

    this.userObj.accountNo = this.signUpForm.value.accountNo;



// calling the service

    this.service.Adduser(this.userObj).subscribe(res => { alert("signUp Successfull.") });



// resetting the form

    this.signUpForm.reset();

  }


}
