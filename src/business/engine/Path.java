package business.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import business.transport.Route;
import business.transport.Station;

public class Path {
	List<Tuple<Station, Route>> path;
	private final float average_speed = 50; // km/h
	
	public Path() {
		path = new ArrayList<Tuple<Station, Route>>();
	}
	
	public Path(List<Tuple<Station, Route>> path) {
		this.path = path;
	}
	
	public void addPathEntry(Station s, Route r) {
		path.add(new Tuple<Station, Route>(s, r));
	}
	
	public void removePathEntry(int index) {
		path.remove(index);
	}
	
	public int getSize() {
		return path.size();
	}
	
	public Tuple<Station, Route> getEntry(int index) {
		return path.get(index);
	}
	
	public float getPathLength() {
		float len = 0;
		ListIterator<Tuple<Station, Route>> iter = path.listIterator();
		
		if(!iter.hasNext()) {
			return (float) 0;
		}
		Tuple<Station, Route> prev = iter.next();
		
		if(!iter.hasNext()) {
			return (float) 0;
		}
		Tuple<Station, Route> cur = iter.next();
		
		while(iter.hasNext()) {
			Station prevStation = prev.x;
			Station curStation = cur.x;
			
			len += prevStation.distanceFrom(curStation);
			
			prev = cur;
			cur = iter.next();
		}
		return len;
	}
	
	public float getPathDuration() {
		float len = getPathLength();
		return len / average_speed * 3600; // in seconds
	}
}
