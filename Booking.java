class Booking{
    private int book_id;
    private Customer c;
    private int drop_time;
    private int charges;

    Booking(int id,int charge,int drop_time,Customer cum){
         this.book_id =id;
         this.drop_time=drop_time;
         this.charges=charge;
         this.c=cum;
    }

    public int getbook_id(){
        return book_id;
    }
    public int getcharges(){
        return charges;
    }
    public int getdrop_time(){
        return drop_time;
    }
    public Customer getcustomer(){
        return c;
    }
    public int getcust_id(){
        return this.c.getcust_id();
    }
    
     public char getpickup(){
        return this.c.getpickup();
    }
    public int getpickup_time(){
        return this.c.getpickup_time();
    }
    public char getdrop(){
        return this.c.getdrop();
    }


}