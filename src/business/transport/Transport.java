package business.transport;

import java.util.ArrayList;
import java.util.HashMap;

public class Transport {

	private static Transport transport = new Transport();
	
	private HashMap<Integer, Station> stations;
	private ArrayList<Route> routes;
	
	private Transport() {
		stations = new HashMap<Integer, Station>();
		routes = new ArrayList<Route>();
	}
	
	private Transport(HashMap<Integer, Station> stations, ArrayList<Route> routes) {
		this.stations = stations;
		this.routes = routes;
	}

	public HashMap<Integer, Station> getStations() {
		return stations;
	}

	public void setStations(HashMap<Integer, Station> stations) {
		this.stations = stations;
	}

	public ArrayList<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}

	public static Transport getTransport() {
		return transport;
	}

	public static void setTransport(Transport transport) {
		Transport.transport = transport;
	}
}
