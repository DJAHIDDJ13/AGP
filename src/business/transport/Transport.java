package business.transport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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
	
	/*
	 * TODO: put this in transport
	 */
	// calculate all stations with repetition 
	/*
	private int calculateNumStationsInRoutes() {
		int n = 0;
		Collection<Route> routes = transport.getRoutes();
		for(Route r: routes) {
			n += r.getStations().size();
		}
		return n;
	}
	*/
	
	/*
	 * TODO: put this in transport
	 */
	// get all route by station 
	/*
	private void buildBuckets() {
		Collection<Route> routes = transport.getRoutes();
		Collection<Station> stations = transport.getStations();
		buckets = new HashMap<Station, List<Route>>(); 

	    for	(Route route: routes) {
	    	for(Station station: stations) {
	    		// TODO: Do this better
	    		try {
	    			buckets.get(station).add(route);
	    		} catch (NullPointerException e) {
	    			List<Route> routeList = new ArrayList<Route>();
	    			routeList.add(route);
	    			buckets.put(station, routeList);
	    		}
	    	}
	    }
	}
	*/
	
}
