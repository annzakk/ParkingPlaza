package parkingPlaza;

import java.util.ArrayList;
import java.util.List;
import parkingPlaza.Automobile;

public class Slot {

	interface LimitCalculator {
        boolean isLimitLeft();
    }

    private static final int FREE = 0; //when the spot is free its equal to 0
    private static final int FULL = 2; //when the parking is equal to 2 its full
    private static int licensePlateCounter = 0; //declare a counter
    private final int licensePlate = ++licensePlateCounter; //counter adds
    private final int Limit; // varible for Limit
    private final List<Automobile> parkingAutomobiles = new ArrayList<>(); //use arraylist for parking the Automobiles

    public Slot(int Limit) { // a slot for the Limit
        this.Limit = Limit;
    }

    public boolean accepts(Automobile Automobile) { //is the Automobile OK?
        return isSlotFree(() -> (Limit >= parkingAutomobiles.get(0).getSpacesNeeded() + Automobile.getSpacesNeeded()));
    }

    public void addAutomobile(Automobile Automobile) { //add Automobile in the parking
        parkingAutomobiles.add(Automobile);
        System.out.println(String.format("%s parked on slot %d", Automobile, licensePlate));
    }

    public boolean isFree() { //if its free return that the slot is free
        return isSlotFree(() -> (Limit > parkingAutomobiles.get(0).getSpacesNeeded()));
    }

    private boolean isSlotFree(LimitCalculator b) { //do a method for the slot if its free
        switch (parkingAutomobiles.size()) {
        case FREE:
            return true;
        case FULL:
            return false;
        default:
            return b.isLimitLeft();
        }
    }

    public void remove(Automobile Automobile) { //a method to remove Automobile from slot
        parkingAutomobiles.remove(Automobile);
        System.out.println(String.format("%s removed from slot %d", Automobile, licensePlate));      
    }

    public String toString() {
        return "Slot [licensePlate: " + licensePlate + ", Limit=" + Limit + ", parkingAutomobiles=" + parkingAutomobiles + "]";
    }
}
