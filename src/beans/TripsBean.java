package beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import business.island.Activity;
import business.island.Hotel;
import business.island.Site;
import business.trip.Excursion;
import business.trip.Trip;


@ManagedBean
@RequestScoped
public class TripsBean implements Serializable{

	private static final long serialVersionUID = 8509374769573963845L;
	
	List<Trip> trips;

	private String hotelName;
	
	private float maximumPrice;

	private int daysCount;
	
	private float density;
	
	public TripsBean() {
		
	}

	public List<Trip> getTrips() {
		// call core to initialize trips here
		return trips;
	}

	public void setTrips(List<Trip> t)
	{
		this.trips = t;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotel) {
		this.hotelName = hotel;
	}

	public float getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(float maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	public int getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(int daysCount) {
		this.daysCount = daysCount;
	}

	public float getDensity() {
		return density;
	}

	public void setDensity(float density) {
		this.density = density;
	}
	
	public String fetchOffers()
	{
		Trip t1 = new Trip();
		Hotel h1 = new Hotel();
		h1.setName("Hotel Royale");
		t1.setHotel(h1);
		t1.setDaysCount(6);
		
		Excursion e1 = new Excursion();
		Site a1  = new Activity();
		a1.setName("ski");
		
		e1.setSite(Arrays.asList(a1,a1,a1));
		
		
		t1.setExcursion(Arrays.asList(e1,e1,e1));
		
		t1.setPrice(120);
		
		this.trips = Arrays.asList(t1,t1,t1);
		
		return "trips";
	}
}
