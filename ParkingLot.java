package parkingPlaza;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import parkingPlaza.Automobile;

public class ParkingLot {
	private final Collection<Slot> freeParkingSlots = new HashSet<>(); //Use hashset to collect the slots
    private final Collection<Slot> allParkingSlots = new HashSet<>(); // collect all parkingslots
    private final Map<Automobile, Slot> parkingAutomobiles = new HashMap<>(); // map key Automobile, and key is slot
    private double income = 0.0; //use a variable to count with something
    private static final PriceCalculator CALCULATOR = new PriceCalculator(); // use calculator 

    public ParkingLot(int numberOfSlots) {
        Random random = new Random(); //create a variable random for the for loop and for the slots
        for (int i = 0; i < numberOfSlots; i++) { //do a for loop to add a slot at the next one
            allParkingSlots.add(new Slot(1 + random.nextInt(3))); //add at the next
        }
        // all slots initially free
        freeParkingSlots.addAll(allParkingSlots);
    }

   public Ticket parkAutomobile(Automobile Automobile) {
        Slot targetSlot = freeParkingSlots.stream().filter(p -> p.accepts(Automobile)).findFirst()
                .orElseThrow(() -> new RuntimeException("No free slot for " + Automobile));
        // use stream to read the different , 
        targetSlot.addAutomobile(Automobile);
        if (!targetSlot.isFree()) { //if its not free remove it
            freeParkingSlots.remove(targetSlot);
        }
        parkingAutomobiles.put(Automobile, targetSlot);
        return new Ticket(Automobile);
    }
 
    public void unparkAutomobile(Ticket ticket) {
        Slot targetSlot = parkingAutomobiles.remove(ticket.getAutomobile());
        targetSlot.remove(ticket.getAutomobile());
        freeParkingSlots.add(targetSlot); // set keeps uniqueness
        income += ticket.calculatePrice(CALCULATOR);
    }

    @Override
    public String toString() {
        return String.format("ParkingLot [income=%.2f, freeParkingSlots=%d, parkingAutomobiles=%d]", income, freeParkingSlots.size(),
                parkingAutomobiles.size());
    }
    
}
