package business.transport;

import java.util.ArrayList;
import java.util.List;

public abstract class Route {
	private int id;
	private float ticketPrice;
	private float routeLength;
	private List<Station> stations;
	private float averageSpeed = 50; // km/h 

	
	public Route() {
		
	}

	// TODO: remove route length not needed
	public Route(int id, float ticketPrice, float routeLength) {
		this.id = id;
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.stations = new ArrayList<Station>();
	}
	
	public Route(int id, float ticketPrice, float routeLength, List<Station> routes) {
		this.id = id;
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.stations = routes;
	}
	
	public Route(int id, float ticketPrice, List<Station> routes) {
		this.id = id;
		this.ticketPrice = ticketPrice;
		this.routeLength = computeLength(routes);
		this.stations = routes;
	}
	
	public float getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public float getRouteLength() {
		return routeLength;
	}

	public void setRouteLength(float routeLength) {
		this.routeLength = routeLength;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	private float computeLength(List<Station> route) {
		// TODO compute the length between all station of this route
		return 0;
	}
	
	public abstract boolean isBoatRoute();
	public abstract boolean isBusRoute();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public float getAverageSpeed() {
		return averageSpeed;
	}
	
	public String toString() {
		return "" + id + " (ticket price " + ticketPrice + "$)";
	}
}