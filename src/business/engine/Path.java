package business.engine;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import business.transport.Route;
import business.transport.Station;

public class Path {
	private List<PathEntry> path;
	private LocalTime start_time = LocalTime.parse("08:00:00");
	
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
		
		if(!iter.hasNext()) return (float) 0;
		PathEntry prev = iter.next();
		
		if(!iter.hasNext()) return (float) 0;
		PathEntry cur = iter.next();
		
		while(iter.hasNext()) {
			// TODO: check err
			len += prev.getDistanceFrom(cur);
			
			prev = cur;
			cur = iter.next();
		}
		return len;
	}

	// in seconds
	public int getPathDuration() {
		int duration = 0;
		ListIterator<PathEntry> iter = path.listIterator();
		
		if(!iter.hasNext()) return 0;
		PathEntry prev = iter.next();
		
		if(!iter.hasNext()) return 0;
		PathEntry cur = iter.next();
		
		while(iter.hasNext()) {
			// TODO: check err
			duration += prev.getDurationFrom(cur);
			
			prev = cur;
			cur = iter.next();
		}		
		return duration;
	}
	
	public List<PathEntry> getPath() {
		return path;
	}
	
	@Override
	public String toString() {
		String res = "";
		
		ListIterator<PathEntry> iter = path.listIterator();
		PathEntry cur, next;
		
		if(!iter.hasNext()) return "Empty path!\n";
		cur = iter.next();

		if(!iter.hasNext()) return "Path only has one station\n";
		next = iter.next();
		
		LocalTime cur_time = start_time;
		while(iter.hasNext()) {
			boolean routeChanged = cur.getRoute() != next.getRoute();
			res += "[" + cur_time + "] ";
			res += "Station: " + cur.getStation();
			if(routeChanged) {
				res += "; Line change " + cur.getRoute();
			}
			res += "\n";
			cur_time = cur_time.plusSeconds(cur.getDurationFrom(next));
			
			cur = next;
			next = iter.next();
		}
		res += "[" + cur_time + "] " + "Station: " + cur.getStation() + " Arrival";
		return res;
	}

	public LocalTime getStartTime() {
		return start_time;
	}

	public void setStartTime(LocalTime start_time) {
		this.start_time = start_time;
	}
}
