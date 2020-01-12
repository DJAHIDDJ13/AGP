package business.transport;

import java.util.HashMap;

public abstract class Route {

	private float ticketPrice;
	private float routeLength;
	
	private HashMap<Integer, Station> stations;
	
	public Route() {
		
	}

	public Route(float ticketPrice, float routeLength) {
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.stations = new HashMap<Integer, Station>();
	}
	
	public Route(float ticketPrice, float routeLength, HashMap<Integer, Station> stations) {
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.stations = stations;
	}
	
	public Route(float ticketPrice, HashMap<Integer, Station> stations) {
		this.ticketPrice = ticketPrice;
		this.routeLength = computeLength(stations);
		this.stations = stations;
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

	public HashMap<Integer, Station> getStations() {
		return stations;
	}

	public void setStations(HashMap<Integer, Station> stations) {
		this.stations = stations;
	}

	private float computeLength(HashMap<Integer, Station> stations2) {
		// TODO compute the lenght between all station of this route
		return 0;
	}
	
	public abstract boolean isBoatRoute();
	public abstract boolean isBusRoute();
}