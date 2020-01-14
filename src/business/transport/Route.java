package business.transport;

import java.util.ArrayList;
import java.util.List;

public abstract class Route {

	private float ticketPrice;
	private float routeLength;
	
	private List<Station> stations;
	
	public Route() {
		
	}

	public Route(float ticketPrice, float routeLength) {
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.stations = new ArrayList<Station>();
	}
	
	public Route(float ticketPrice, float routeLength, List<Station> stations) {
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.stations = stations;
	}
	
	public Route(float ticketPrice, List<Station> stations) {
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
}