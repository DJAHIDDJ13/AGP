package business.transport;

import java.util.HashMap;

public class BusRoute extends Route{

	public BusRoute() {
		super();
	}

	public BusRoute(float ticketPrice, float routeLength) {
		super(ticketPrice, routeLength);
	}
	
	public BusRoute(float ticketPrice, float routeLength, HashMap<Integer, Station> stations) {
		super(ticketPrice, routeLength, stations);
	}
	
	public BusRoute(float ticketPrice, HashMap<Integer, Station> stations) {
		super(ticketPrice, stations);
	}
	
	@Override
	public boolean isBoatRoute() {
		return false;
	}

	@Override
	public boolean isBusRoute() {
		return true;
	}
}