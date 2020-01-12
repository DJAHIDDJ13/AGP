package business.transport;

import java.util.ArrayList;
import java.util.List;

public abstract class Route {

	private float ticketPrice;
	private float routeLength;
	
	private List<Station> routes;
	
	public Route() {
		
	}

	public Route(float ticketPrice, float routeLength) {
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.routes = new ArrayList<Station>();
	}
	
	public Route(float ticketPrice, float routeLength, List<Station> routes) {
		this.ticketPrice = ticketPrice;
		this.routeLength = routeLength;
		this.routes = routes;
	}
	
	public Route(float ticketPrice, List<Station> routes) {
		this.ticketPrice = ticketPrice;
		this.routeLength = computeLength(routes);
		this.routes = routes;
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
		return routes;
	}

	public void setStations(List<Station> route) {
		this.routes = route;
	}

	private float computeLength(List<Station> route) {
		// TODO compute the length between all station of this route
		return 0;
	}
	
	public abstract boolean isBoatRoute();
	public abstract boolean isBusRoute();
}