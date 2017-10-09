package parkingPlaza;

public class PriceCalculator {
	public double getPrice(long parkingDuration, double priceFactor) {
        return parkingDuration * priceFactor;
    }
}
