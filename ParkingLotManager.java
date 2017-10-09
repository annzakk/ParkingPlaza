package parkingPlaza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParkingLotManager { // 
	    private final ParkingLot parkingLot;
	    String[] AutomobileTypes = { "Car", "Truck", "Bus" };

	    public ParkingLotManager(int numberOfSlots) {
	        parkingLot = new ParkingLot(numberOfSlots);
	    }

	    public static void main(String[] args) {
	        int numberOfSlots = 10;// the number of slots  // would love to learn how to write it myself instead
	        int numberOfIterations = 5;// number of iterations
	        new ParkingLotManager(numberOfSlots).start(numberOfIterations); //the main go through the number of iterations
	    }

	    private void start(int numberOfIterations) {
	        List<Ticket> tickets = new ArrayList<>(); //use the arraylist to and a random for the type 
	        Random random = new Random();
	        for (int i = 0; i < numberOfIterations; i++) { //for loop the number of iterations. would be useful if we would get an input
	            int nextInt = random.nextInt(1 + tickets.size()); //the nextInt get a one size bigger ticket
	            if (nextInt > tickets.size() * 2 / 3) { //if next int is bigger than the ticketsize park then take it from parkinglot
	                parkingLot.unparkAutomobile(tickets.remove(random.nextInt(tickets.size())));
	            } else {
	                try {
	                    parkNewAutomobile(tickets, i); //if it does not work use a exeption to print message
	                } catch (Exception e) {
	                    System.out.println("Automobile not parked: "+e.getMessage());
	                }
	            }
	            System.out.println(parkingLot);
	        }
	    }

	    private void parkNewAutomobile(List<Ticket> tickets, int i) { //a method to park a new car, used above
	        String AutomobileType = AutomobileTypes[new Random().nextInt(AutomobileTypes.length)]; //
	        int spacesNeeded = 1 + Arrays.asList(AutomobileTypes).indexOf(AutomobileType); //dependng on type add one space
	        double priceFactor = 0.2 + (0.2 * spacesNeeded); //more price for the spaces needed
	        tickets.add(parkingLot.parkAutomobile(new Automobile(AutomobileType, i, spacesNeeded, priceFactor)));
	    }
}
