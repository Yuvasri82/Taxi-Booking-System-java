class Customer{
    private int cust_id;
    private char pickup;
    private char drop;
    private int pickup_time;

    Customer(int id,char pickup,char drop,int time){
        this.cust_id=id;
        this.pickup=pickup;
        this.drop=drop;
        this.pickup_time=time;
    }
     public int getcust_id(){
        return cust_id;
     }
    public char getpickup(){
        return pickup;
    }
    public int getpickup_time(){
        return pickup_time;
    }
    public char getdrop(){
        return drop;
    }

}