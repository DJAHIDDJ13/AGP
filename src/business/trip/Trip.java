package business.trip;

import java.util.List;

import business.island.Hotel;
import business.island.Site;

public class Trip {
	
	private Hotel hotel;
	
	private List<Excursion> excursion;
	
	private float price;
	
	private float daysCount;
	
	
	public Trip() {
		
	}
	
	public Trip(Hotel hotel, List<Excursion> excursion) {
		this.hotel = hotel;
		this.excursion = excursion;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Excursion> getExcursion() {
		return excursion;
	}

	private void constructTrip(List<Site> sites, Hotel hotel, int budgetMin, int budgetMax) {
		
	}

	public void setExcursion(List<Excursion> excursion) {
		this.excursion = excursion;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDensity() {
		return (((float) excursion.size()) /daysCount );
	}

	public float getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(float daysCount) {
		this.daysCount = daysCount;
	}
}
