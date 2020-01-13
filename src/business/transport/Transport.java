package business.transport;

import java.util.Collection;
import java.util.HashMap;

public class Transport {

	private static Transport transport = new Transport();
	
	private HashMap<Integer, Station> stations;
	private HashMap<Integer, Route> routes;
	
	private Transport() {
		stations = new HashMap<Integer, Station>();
		routes = new HashMap<Integer, Route>();
	}
	
	private Transport(HashMap<Integer, Station> stations, HashMap<Integer, Route> routes) {
		this.stations = stations;
		this.routes = routes;
	}

	public void addStation(int id, Station station) {
		stations.put(id, station);
	}
	
	public void addRoute(int id, Route route) {
		routes.put(id, route);
	}
	
	public Collection<Station> getStations() {
		return stations.values();
	}
	/*
	public void setStations(HashMap<Integer, Station> stations) {
		this.stations = stations;
	}
	*/
	public Collection<Route> getRoutes() {
		return routes.values();
	}
	
	/*
	public void setRoutes(HashMap<Integer, Route> routes) {
		this.routes = routes;
	}
	*/

	public static Transport getTransport() {
		return transport;
	}

	public static void setTransport(Transport transport) {
		Transport.transport = transport;
	}

	public Station getStationById(int curId) {
		return stations.get(curId);
	}

	public Route getRouteById(int id) {
		return routes.get(id);
	}
}
