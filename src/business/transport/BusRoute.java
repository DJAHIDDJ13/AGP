package business.transport;

import java.util.List;

public class BusRoute extends Route{

	public BusRoute() {
		super();
	}

	public BusRoute(int id, float ticketPrice, float routeLength) {
		super(id, ticketPrice, routeLength);
	}
	
	public BusRoute(int id, float ticketPrice, float routeLength, List<Station> route) {
		super(id, ticketPrice, routeLength, route);
	}
	
	public BusRoute(int id, float ticketPrice, List<Station> route) {
		super(id, ticketPrice, route);
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