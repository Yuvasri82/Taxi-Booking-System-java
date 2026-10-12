public class Main{
    public static void main(String[] args){
        
        Customer c1 = new Customer(1,'A', 'B', 9);
            Customer c2 = new Customer(2, 'B', 'D', 9);
            Customer c3 = new Customer(3, 'B', 'C', 12);

        Booking_system b = new Booking_system(4);
        b.booktaxi(c1);
        b.booktaxi(c2); 
        b.booktaxi(c3);
        b.displayTaxi();
    }
}