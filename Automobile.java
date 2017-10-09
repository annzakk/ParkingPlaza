package parkingPlaza;


public class Automobile {
		private final int licensePlate; // both private and final so its in the sublclass and class
		private final int spacesNeeded; // create variables for everything in vehicle
		private final double priceFactor; 
		private String automobileType;
		
		public Automobile(String AutomobileType, int licensePlate, int spacesNeeded, double priceFactor){
			super(); //calls the parent construction
			this.automobileType = AutomobileType;
			this.licensePlate = licensePlate;
			this.spacesNeeded = spacesNeeded;
			this.priceFactor = priceFactor;
		}
		
	public int getSpacesNeeded(){
		return spacesNeeded;
	}
	
	public double getPriceFactor(){
		return priceFactor;
	}
	public String toString(){
		return String.format("Automobile[automobileType=%s, licensePlate=%d, spacesNeeded=%d, priceFactor=%.2f]", automobileType, licensePlate, 
				spacesNeeded, priceFactor);
	} //use %s to get a insert of String, %d for insert of number, and %.2f an output of data with 2 decimals 
	
}
