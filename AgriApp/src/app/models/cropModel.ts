export class cropModel{

    constructor(
        public farmerId:String,
        public cropId:String,
        public cropName:String,
        public cropQty:Number
        ,public cropType:String
        ,public cropPrice:String,
        public cropImgUrl:String,
        public cropDesc:String,
        
    )
        {
        this.farmerId=farmerId;
        this.cropId=cropId;
        this.cropName=cropName;
        this.cropQty=cropQty;
        this.cropType=cropType;
        this.cropPrice=cropPrice;
    }
}