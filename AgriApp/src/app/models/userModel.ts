export class userModel{

    userId:String = "U"+Math.random() * (900 - 100 + 1) + 100;
constructor(
    public userName:String,
    public userEmail:String,
    public location:String,
    public accountNo:String,
    public mobileNo:String,
    public userType:String,
    public password:String
)
    
    {
       this.userName=userName;
       this.userEmail=userEmail;
       this.location=location;
       this.accountNo=accountNo;
       this.mobileNo=mobileNo;
       this.userType=userType;
       this.password=password;
    
}
}