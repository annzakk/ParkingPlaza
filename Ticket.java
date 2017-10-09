package parkingPlaza;

import parkingPlaza.PriceCalculator;
import parkingPlaza.Automobile;

public class Ticket {
	 	private final long startTime = System.currentTimeMillis(); //create variable so u can calculate
	    private final Automobile automobile;

	    public Ticket(Automobile automobile) {
	        super();
	        this.automobile = automobile;
	    }
	    public long calcualteParkingDuration(){
	        return System.currentTimeMillis() - startTime; //method explains itself
	    }
	    public double calculatePrice(PriceCalculator calculator){
	        return calculator.getPrice(calcualteParkingDuration(), automobile.getPriceFactor());
	    }

	    public Automobile getAutomobile(){
	        return automobile;
	    }
}
