package business.transport;

import java.util.List;

import business.transport.Route;
import business.transport.Station;

public class BoatRoute extends Route{
	
	public BoatRoute() {
		super();
	}

	public BoatRoute(float ticketPrice, float routeLength) {
		super(ticketPrice, routeLength);
	}
	
	public BoatRoute(float ticketPrice, float routeLength, List<Station> route) {
		super(ticketPrice, routeLength, route);
	}
	
	public BoatRoute(float ticketPrice, List<Station> route) {
		super(ticketPrice, route);
	}
	
	@Override
	public boolean isBoatRoute() {
		return true;
	}

	@Override
	public boolean isBusRoute() {
		return false;
	}
}