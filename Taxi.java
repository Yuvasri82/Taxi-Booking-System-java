import java.util.*;
class Taxi{
    private int taxiid;
    private char currspot;
    private int freetime;
    private int earnings;
    private List<Booking> bookings;

    Taxi(int id){
       this.taxiid=id;
       this.currspot='A';
       this.freetime=0;
       this.earnings=0;
       bookings = new ArrayList<>();
    }

    public int gettaxiId(){
        return taxiid;
    }
    public char getcurrspot(){
        return currspot;
    }
    public int getfreetime(){
        return freetime;
    }
    public int getearnings(){
        return earnings;
    }
    public List<Booking> getBookings(){
        return bookings;
    }
    public void setcurrspot(char currspot){
          this.currspot=currspot;
    }
    public void setfreetime(int time){
        this.freetime=time;
    }
    public  void setearnings(int earning){
        this.earnings=earning;
    }

    public boolean isfree(char pickup,int pickup_time){
         int traveltime=Math.abs(pickup-currspot);
         if(freetime+traveltime <= pickup_time){
            return true;
         }
         return false;
    }
    public void assignbooking(Booking b){
           bookings.add(b);
    }

}