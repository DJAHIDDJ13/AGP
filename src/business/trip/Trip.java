package business.trip;

import java.util.List;

import business.island.Hotel;
import business.island.Site;

public class Trip {
	
	private Hotel hotel;
	
	private List<Excursion> excursion;
	private List<Site> sites;

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

	@SuppressWarnings("unused")
	private void constructTrip(List<Site> sites, Hotel hotel, int budgetMin, int budgetMax) {
		
	}

	public void setExcursion(List<Excursion> excursion) {
		this.excursion = excursion;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
}
