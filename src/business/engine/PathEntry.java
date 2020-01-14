package business.engine;

import java.util.HashMap;

import business.transport.Route;
import business.transport.Station;

public class PathEntry {
	Tuple<Station, Route> entry;
	static HashMap<String, PathEntry> entries = new HashMap<String, PathEntry>();
	
	public PathEntry(Station s, Route r) {
		if(entries.get(generateKey(s, r)) == null) {
			entry = new Tuple<Station, Route>(s, r);
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
		return entry.x;
	}
	
	public Route getRoute() {
		return entry.y;
	}
}