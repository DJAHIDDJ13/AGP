package business.engine;

import java.util.HashMap;

import business.transport.Route;
import business.transport.Station;

public class PathEntry {
	private Station station;
	private Route route;
	static HashMap<String, PathEntry> entries = new HashMap<String, PathEntry>();
	
	public PathEntry(Station s, Route r) {
		if(entries.get(generateKey(s, r)) == null) {
			this.station = s;
			this.route = r;
			entries.put(generateKey(s, r), this);
		}
	}
	
	public static String generateKey(Station s, Route r) {
		return String.valueOf(s.getId()) + ";" + String.valueOf(s.getId());
	}
	
	public static PathEntry getEntry(Station s, Route r) {
		PathEntry pathEntry = entries.get(generateKey(s, r));
		if(pathEntry == null) {
			return new PathEntry(s, r);
		}
		
		return pathEntry;
	}
	
	public static void removeEntry(Station s, Route r) {
		entries.remove(generateKey(s, r));
	}
	
	public Station getStation() {
		return station;
	}
	
	public Route getRoute() {
		return route;
	}
}