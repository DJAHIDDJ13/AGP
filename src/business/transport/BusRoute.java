package business.transport;

import java.util.List;

public class BusRoute extends Route{

	public BusRoute() {
		super();
	}

	public BusRoute(float ticketPrice, float routeLength) {
		super(ticketPrice, routeLength);
	}
	
	public BusRoute(float ticketPrice, float routeLength, List<Station> route) {
		super(ticketPrice, routeLength, route);
	}
	
	public BusRoute(float ticketPrice, List<Station> route) {
		super(ticketPrice, route);
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