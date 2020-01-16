package business.trip;

import java.util.Comparator;
import business.island.Hotel;

class HotelCmparator implements Comparator<Hotel> {
	private float price;
	
	public HotelCmparator(float price) {
		this.price = price;
	}
    
	public int compare(Hotel a, Hotel b) {
		float value1 = Math.abs(a.getPricePerDay() - price);
		float value2 = Math.abs(b.getPricePerDay() - price);
		
		return (value1 < value2) ? 1 : -1;
    }
}