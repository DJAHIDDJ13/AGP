package beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import business.island.ActivitySite;
import business.island.Hotel;
import business.island.Site;
import business.trip.Excursion;
import business.trip.Trip;
import business.trip.TripSimulation;
import spring.SpringIoC;


@ManagedBean
@RequestScoped
public class TripsBean implements Serializable{

	private static final long serialVersionUID = 8509374769573963845L;
	
	List<Trip> trips;

	private String hotelName;
	
	private float maximumPrice;

	private int daysCount;
	
	private float density;
	
	private TripSimulation trip = (TripSimulation) SpringIoC.getBean("tripSimulation");
 
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
		this.trips = trip.generateTrips(1, "plage", 1000, 10, 1);
		
		return "trips";
	}
}
