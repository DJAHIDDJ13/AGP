package business.engine;

import java.util.HashMap;

import business.transport.Route;
import business.transport.Station;

public class PathEntry implements Graphable {
	Tuple<Station, Route> entry;
	static HashMap<String, PathEntry> entries;
	private boolean virtual = false;
	
	public PathEntry(Station s, Route r) {
		if(getEntry(s, r) == null) {
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
	
	Station getStation() {
		return entry.x;
	}
	
	Route getRoute() {
		return entry.y;
	}

	public void setVirtual(boolean virtual) {
		this.virtual = virtual;
	}
	
	@Override
	public boolean isVirtual() {
		return virtual;
	}
}