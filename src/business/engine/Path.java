package business.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import business.transport.Route;
import business.transport.Station;

public class Path {
	List<PathEntry> path;
	
	private final float average_speed = 50; // km/h
	
	public Path() {
		path = new ArrayList<PathEntry>();
	}
	
	public Path(List<PathEntry> path) {
		this.path = path;
	}
	
	public void addPathEntry(Station s, Route r) {
		path.add(new PathEntry(s, r));
	}
	
	public void removePathEntry(int index) {
		path.remove(index);
	}
	
	public int getSize() {
		return path.size();
	}
	
	public PathEntry getEntry(int index) {
		return path.get(index);
	}
	
	public float getPathLength() {
		float len = 0;
		ListIterator<PathEntry> iter = path.listIterator();
		
		if(!iter.hasNext()) {
			return (float) 0;
		}
		PathEntry prev = iter.next();
		
		if(!iter.hasNext()) {
			return (float) 0;
		}
		PathEntry cur = iter.next();
		
		while(iter.hasNext()) {
			Station prevStation = prev.getStation();
			Station curStation = cur.getStation();
			
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

	public List<PathEntry> getPath() {
		return path;
	}
}
