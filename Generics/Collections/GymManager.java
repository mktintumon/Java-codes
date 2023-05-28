import java.util.*;

class Gym{
    private String name;
    private double distance;
    private String landmark;
    private String contact;

    public Gym(String name, double distance, String landmark, String contact) {
        this.name = name;
        this.distance = distance;
        this.landmark = landmark;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getContact() {
        return contact;
    }
}

class distanceComparator implements Comparator<Gym>{
    public int compare(Gym g1 , Gym g2){
        if (g1.getDistance() == g2.getDistance())
            return 0;
        else if (g1.getDistance() > g2.getDistance())
            return 1;
        else
            return -1;
    }
}

public class GymManager {
    public static void main(String[] args) {
        // Create and add three Gym objects to the LinkedList
        Gym gym1 = new Gym("Fitness First", 5.3, "City Center", "1234567890");
        Gym gym2 = new Gym("Golds Gym", 3.8, "Central Park", "9876543210");
        Gym gym3 = new Gym("Anytime Fitness", 1.1, "Main Street", "5678901234");

        LinkedList<Gym> gyms = new LinkedList<>();
        gyms.add(gym1);
        gyms.add(gym2);
        gyms.add(gym3);

        // Iterate through the elements of the LinkedList
        System.out.println("All Gyms:");
        for (Gym g : gyms) {
            System.out.println("Name: "+g.getName()+", Distance: "+g.getDistance());
        }

        // Sort the LinkedList in ascending order of distance
        Collections.sort(gyms, new distanceComparator());

        System.out.println("\nGyms Sorted by Distance:");
        for (Gym g : gyms) {
            System.out.println("Name: "+g.getName()+", Distance: "+g.getDistance());
        }

        // Display gyms and their landmarks within two kilometers from your place
        double maxDistance = 2.0;
        System.out.println("\nGyms within Two Kilometers:");
        for (Gym g : gyms) {
            if (g.getDistance() <= maxDistance) {
                System.out.println("Name: " +g.getName()+", Landmark: "+g.getLandmark());
            }
        }
    }
}

