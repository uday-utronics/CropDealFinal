export class paymentModel{

    constructor(
        public paymentID:String,
        public orderID:String,
        public orderName:String,
        public paymentTo:String,
        public paymentFrom:String,
        public paymentAmount:String
    )
    {
        this.paymentID=paymentID;
        this.orderID=orderID;
        this.orderName=orderName;
        this.paymentTo=paymentTo;
        this.paymentFrom=paymentFrom;
        this.paymentAmount=paymentAmount;
    }
}