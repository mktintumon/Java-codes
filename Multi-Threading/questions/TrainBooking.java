import java.util.ArrayList;
import java.util.List;


class PassengerThread extends Thread {
    
    private TrainBooking bookingSystem;
    private String passengerName;
    private int numSeats;
    private List<Integer> seatNumbers;
    
    public PassengerThread(TrainBooking bookingSystem, String passengerName, int numSeats) {
        this.bookingSystem = bookingSystem;
        this.passengerName = passengerName;
        this.numSeats = numSeats;
        this.seatNumbers = new ArrayList<>();
    }
    
    public void run() {
        bookingSystem.bookTicket(passengerName, numSeats, seatNumbers);
        System.out.println(passengerName + " booked seats: " + seatNumbers);
    }
}

class TrainBooking {
    
    private int availableSeats;
    private List<Integer> bookedSeats;
    
    public TrainBooking(int capacity) {
        availableSeats = capacity;
        bookedSeats = new ArrayList<>();
    }
    
    public synchronized void bookTicket(String passengerName, int numSeats, List<Integer> seatNumbers) {
        if (numSeats > availableSeats) {
            System.out.println("Sorry, there are only " + availableSeats + " seats available.");
            return;
        }
        
        System.out.println("Booking " + numSeats + " seat(s) for " + passengerName);
        
        // assign seat numbers to the passenger
        for (int i = 0; i < numSeats; i++) {
            int seatNumber = getNextAvailableSeatNumber();
            seatNumbers.add(seatNumber);
            bookedSeats.add(seatNumber);
        }
        
        availableSeats -= numSeats;
        System.out.println("Booking successful. Remaining seats: " + availableSeats);
    }
    
    private int getNextAvailableSeatNumber() {
        for (int i = 1; i <= 100; i++) {
            if (!bookedSeats.contains(i)) {
                return i;
            }
        }
        return -1; // all seats are booked
    }
    
    public static void main(String[] args) {
        TrainBooking bookingSystem = new TrainBooking(100);
        List<PassengerThread> threads = new ArrayList<>();
        
        // create multiple passenger threads to book tickets
        threads.add(new PassengerThread(bookingSystem, "Alice", 2));
        threads.add(new PassengerThread(bookingSystem, "Bob", 3));
        threads.add(new PassengerThread(bookingSystem, "Charlie", 4));
        threads.add(new PassengerThread(bookingSystem, "Dave", 1));
        threads.add(new PassengerThread(bookingSystem, "Eve", 5));
        
        // start all passenger threads
        for (PassengerThread thread : threads) {
            thread.start();
        }
        
        // wait for all passenger threads to finish
        for (PassengerThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("All passengers have booked their tickets.");
    }
}


