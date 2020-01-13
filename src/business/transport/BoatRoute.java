package business.transport;

import java.util.List;

import business.transport.Route;
import business.transport.Station;

public class BoatRoute extends Route{
	
	public BoatRoute() {
		super();
	}

	public BoatRoute(int id, float ticketPrice, float routeLength) {
		super(id, ticketPrice, routeLength);
	}
	
	public BoatRoute(int id, float ticketPrice, float routeLength, List<Station> route) {
		super(id, ticketPrice, routeLength, route);
	}
	
	public BoatRoute(int id, float ticketPrice, List<Station> route) {
		super(id, ticketPrice, route);
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