package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.trip.Trip;
import business.trip.TripSimulation;
import spring.SpringIoC;


@ManagedBean
@SessionScoped
public class TripsBean implements Serializable{

	private static final long serialVersionUID = 8509374769573963845L;
	
	List<Trip> trips;

	private String searchKeyword;

	private int intensite;

	private TripSimulation trip = (TripSimulation) SpringIoC.getBean("tripSimulation");

	private int offersCount;

	private float maximumPrice;

	private int daysCount;

	public TripsBean() {
		trip.init();		
	}

	public List<Trip> getTrips() {
		// call core to initialize trips here
		return trips;
	}

	public void setTrips(List<Trip> t)
	{
		this.trips = t;
	}

	
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
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
	

	public int getIntensite() {
		return intensite;
	}

	public void setIntensite(int intensite) {
		this.intensite = intensite;
	}

	public int getOffersCount() {
		return offersCount;
	}

	public void setOffersCount(int offersCount) {
		this.offersCount = offersCount;
	}
	
	public String fetchOffers()
	{
		this.trips = trip.generateTrips(offersCount,searchKeyword,maximumPrice, daysCount,intensite );

		return "trips";
	}
}
