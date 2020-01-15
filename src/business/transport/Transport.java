package business.transport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Transport {

//	private static Transport transport = new Transport();
	
	private HashMap<Integer, Station> stations;
	private HashMap<Integer, Route> routes;
	
	public Transport() {
		this.stations = new HashMap<Integer, Station>();
		this.routes = new HashMap<Integer, Route>();
	}
	
	public Transport(HashMap<Integer, Station> stations, HashMap<Integer, Route> routes) {
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

	public Collection<Route> getRoutes() {
		return routes.values();
	}

	public Station getStationById(int curId) {
		return stations.get(curId);
	}

	public Route getRouteById(int id) {
		return routes.get(id);
	}

	private int calculateNumStationsInRoutes() {
		int n = 0;
		Collection<Route> routesCollection = routes.values();
		for(Route r: routesCollection) {
			n += r.getStations().size();
		}
		return n;
	}
		
	public HashMap<Station, List<Route>> buildRoutesByStation() {
		Collection<Route> routesCollection = routes.values();
		Collection<Station> stationsCollection = stations.values();
		
		HashMap<Station, List<Route>> routesByStation = new HashMap<Station, List<Route>>(); 
		
	    for	(Route route: routesCollection) {
	    	for(Station station: stationsCollection) {
	    		// TODO: Do this better
	    		try {
	    			routesByStation.get(station).add(route);
	    		} catch (NullPointerException e) {
	    			List<Route> routeList = new ArrayList<Route>();
	    			routeList.add(route);
	    			routesByStation.put(station, routeList);
	    		}
	    	}
	    }
	    
	    return routesByStation;
	}

	public int getNumberStationInRoutes() {
		return calculateNumStationsInRoutes();
	}
}
