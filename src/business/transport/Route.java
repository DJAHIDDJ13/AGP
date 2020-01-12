package business.transport;

import java.util.ArrayList;
import java.util.List;

public abstract class Route {

	private float ticketPrice;
	private float routeLength;
	
	private List<Station> route;
	
	public Route() {
		
	}

	public Route(float ticketPrice, float routeLength) {
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.route = new ArrayList<Station>();
	}
	
	public Route(float ticketPrice, float routeLength, List<Station> route) {
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.route = route;
	}
	
	public Route(float ticketPrice, List<Station> route) {
		this.ticketPrice = ticketPrice;
		this.routeLength = computeLength(route);
		this.route = route;
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
		return route;
	}

	public void setStations(List<Station> route) {
		this.route = route;
	}

	private float computeLength(List<Station> route) {
		// TODO compute the length between all station of this route
		return 0;
	}
	
	public abstract boolean isBoatRoute();
	public abstract boolean isBusRoute();
}