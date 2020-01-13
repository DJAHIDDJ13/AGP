package business.trip;

import java.util.List;

import business.island.Hotel;

public class Trip {
	
	private Hotel hotel;
	
	private List<Excursion> excursion;

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

	public void setExcursion(List<Excursion> excursion) {
		this.excursion = excursion;
	}
}