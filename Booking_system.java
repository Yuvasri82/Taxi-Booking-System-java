import java.util.*;
public class Booking_system{
    private  List<Taxi> taxis;
    Booking_system(int count){
        private int book_id=001;
        taxis= new ArrayList<>();
       for(int i=1;i<=count;i++){
           Taxi t = new Taxi(i);
           taxis.add(t);
        }   
   
    }

    public int calcharges(char pickup,char drop){
        int distance=Math.abs(pickup-drop)*15;
        if(distance<=5){
            return 100;
        }
        int amount=100;
        int balance=(distance-5)*10;
        amount+=balance;

        return amount;
    }

    public Taxi findtaxi(char pickup,int pick_time){
        // adding all the free taxis at the given pickuptime in a list 
        List<Taxi> freetaxi= new ArrayList<>();
        for(Taxi t : taxis){
            if(t.isfree(pickup,pick_time)){
                freetaxi.add(t);
            }
        }
        if(freetaxi.isEmpty()){
            return null;
        }
        //find the minimum distance taxi  to pickup 
        int minimum_distance=Integer.MAX_VALUE;
        for(Taxi t : freetaxi){
            int distance=Math.abs(t.getcurrspot()-pickup);
            if(distance<minimum_distance){
                minimum_distance=distance;
            }
        }
        //here we match all the taxis that are in same minimum distance to pickup and add it in list 
        List<Taxi> closest = new ArrayList<>();
        for(Taxi t : freetaxi){
            int distance=Math.abs(t.getcurrspot()-pickup);
            if(distance==minimum_distance){
                closest.add(t);
            }
        }
        //Among closest assign to who has low earnings
        Taxi selected = closest.get(0);
        for(Taxi t : closest){
            if(t.getearnings()<selected.getearnings()){
                selected=t;
            }
        }
        return selected;

    }
    
    public void booktaxi(Customer c){
       
        Taxi selected=findtaxi(c.getpickup(),c.getpickup_time());
        if(selected==null){
            System.out.println("Taxi is not available at the moment");
            System.out.println("pls try later.....");
            return;
        }
        System.out.println("taxi - " + selected.gettaxiId() + "is booked" );
        

        //Adding it to the booking 
        int charge=calcharges(c.getpickup(),c.getdrop());
        int traveltime= Math.abs(c.getdrop()-c.getpickup());
        int droptime=c.getpickup_time()+traveltime;
        Booking book = new Booking(book_id,charge,droptime,c);
        book_id++;
        
        selected.setcurrspot(c.getdrop());
        selected.setfreetime(droptime);
        selected.setearnings(selected.getearnings()+ charge);
        selected.assignbooking(book);

    }

        //printing all the bookings for each taxi 
        public void displayTaxi(){
        for(Taxi t : taxis){
            System.out.println("Taxi-id:"+ t.gettaxiId()+" Total Earnings:" + t.getearnings());
            System.out.println("Booking Id\tCustomer Id\tFrom\tTo\tpickup Time\tDrop Time");
            for(Booking b:t.getBookings()){
                System.out.println(b.getbook_id()+"\t\t"+b.getcust_id()+"\t\t"+
                b.getpickup()+"\t\t"+b.getdrop()+"\t\t"+b.getpickup_time()+"\t\t"+b.getdrop_time());
            }
            System.out.println();
        }
        }

    
}