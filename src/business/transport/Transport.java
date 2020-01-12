package business.transport;

import java.util.ArrayList;
import java.util.List;

public class Transport {

	private static Transport transport = new Transport();
	
	private List<Station> stations;
	private List<Route> routes;
	
	private Transport() {
		stations = new ArrayList<Station>();
		routes = new ArrayList<Route>();
	}
	
	private Transport(List<Station> stations, List<Route> routes) {
		this.stations = stations;
		this.routes = routes;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public static Transport getTransport() {
		return transport;
	}

	public static void setTransport(Transport transport) {
		Transport.transport = transport;
	}
}
