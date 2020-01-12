package business.transport;

import java.util.HashMap;

public class BoatRoute extends Route{
	
	public BoatRoute() {
		super();
	}

	public BoatRoute(float ticketPrice, float routeLength) {
		super(ticketPrice, routeLength);
	}
	
	public BoatRoute(float ticketPrice, float routeLength, HashMap<Integer, Station> stations) {
		super(ticketPrice, routeLength, stations);
	}
	
	public BoatRoute(float ticketPrice, HashMap<Integer, Station> stations) {
		super(ticketPrice, stations);
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