package business.engine;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import business.island.Hotel;
import business.island.Site;
import business.transport.Route;
import business.transport.Station;
import business.transport.Transport;
import business.trip.Excursion;

public class PathFinding {

	private Transport transport;

	private Graph transport_graph;
	
	// routes graph 
	public PathFinding(Transport transport) {
		this.transport = transport;
		buildTransportGraph();
	}
	
	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	// TODO: This needs to change; not good
	private void buildTransportGraph() {
		 transport_graph = new Graph();

		Collection<Route> routes = transport.getRoutes();
	    Collection<Station> stations = transport.getStations();

	    // connect all the consecutive route stations with a 0 weight node
	    for	(Route route: routes) {
	    	ListIterator<Station> stationRoutes = route.getStations().listIterator();
	        if(!stationRoutes.hasNext()) continue;

	        // TODO: sanity check
	        Station src = stationRoutes.next();
	        while(stationRoutes.hasNext()) {
	            Station dst = stationRoutes.next();
	            
	        	PathEntry srcEntry = PathEntry.getEntry(src, route);
	        	PathEntry dstEntry = PathEntry.getEntry(dst, route);
	        	
    	    	transport_graph.addAdjacencyEntry(srcEntry, new Node(dstEntry, 0));
    	    	src = dst;
	        }
	    }
	    
	    
	    HashMap<Station, List<Route>> routesByStation = transport.buildRoutesByStation();
		for(Station station: stations) {
	    	List<Route> lst = routesByStation.get(station);
	    	
	    	// get all the possible pairs of stations
	    	for (int i = 0; i < lst.size(); i++) {
	    	    for (int j = i + 1; j < lst.size(); j++) {
	    	    	Route srcRoute = lst.get(i);
	    	    	Route dstRoute = lst.get(j);
	    	    	
	    	    	PathEntry srcEntry = PathEntry.getEntry(station, srcRoute);
	    	    	PathEntry dstEntry = PathEntry.getEntry(station, dstRoute);

	    	    	transport_graph.addAdjacencyEntry(srcEntry, new Node(dstEntry, dstRoute.getTicketPrice()));
	    	    }
	    	}
	    }
	}
	
	public Path findCheapestPath(Station A, Station B) { // (List<Station> path) {		
		// Adding the S and E node to the graph
		PathEntry S = PathEntry.getEntry(new Station(-1, null), null); // dummy entry 
		PathEntry E = PathEntry.getEntry(new Station(-2, null), null); // dummy entry
		
		HashMap<Station, List<Route>> routesByStation = transport.buildRoutesByStation();
		List<Route> strtStation = routesByStation.get(A); // get all the lines that pass by the start Station
		List<Route> endStation = routesByStation.get(B); // get all the lines that pass by the end Station
		
		// Adding the "S" node
		for	(Route r: strtStation) {
			// String key = String.valueOf(A.getId())+";"+String.valueOf(r.getId());
			PathEntry entry = PathEntry.getEntry(A, r);
			
			transport_graph.addAdjacencyEntry(S, new Node(entry, r.getTicketPrice()));
		}
		
		// Adding the "E" node
		for (Route r: endStation) {
			PathEntry entry = PathEntry.getEntry(B, r);
			transport_graph.addAdjacencyEntry(entry, new Node(E, 0));
		}
		
		transport_graph.dijkstra(S);
		
		// removing the S node
		transport_graph.removeAdjacencyList(S);
		
		// removing the E node
		// Undo nodes to last station
		HashMap<PathEntry, List<Node>> adj = transport_graph.getAdj();
		for (Route r: endStation) {
			PathEntry entry = PathEntry.getEntry(B, r);
			List<Node> endLst = adj.get(entry);
			endLst.remove(endLst.size() - 1);
			if(endLst.size() == 0) { // to save space 
				adj.remove(entry);
			}
			// remove last item added (which is the "E" node)
		}
		
		// TODO: Use this on the resulting path
		// TODO: change AbstractMap.SimpleEntry to something better
		List<PathEntry> lst = transport_graph.getPath(S, E);

		if(lst == null) {
			return null;
		}
		
		lst.remove(0); lst.remove(lst.size() - 1); // remove the S and E nodes

		Path path = new Path(lst);
		
		return path;
	}
	
	public Site getMinSite(Site cur, Station hotelStation, List<Site> sites) {
		Site min = null;
		int minDuration = Integer.MAX_VALUE;

		for(Site site: sites) {
			// spend time at site
			int siteDuration = site.getDuration();
			int totalTime = siteDuration;

			// path to the site
			Path awayPath = findCheapestPath(cur.getStation(), site.getStation());
			int awayPathDuration = awayPath.getPathDuration(LocalTime.NOON);
			totalTime = totalTime + awayPathDuration;

			// path back to hotel
			Path backPath = findCheapestPath(site.getStation(), hotelStation);
			int backPathDuration = backPath.getPathDuration(LocalTime.NOON);
			totalTime = totalTime + backPathDuration;
			
			// If new minimum found
			if(totalTime < minDuration) {
				minDuration = totalTime;
				min = site;
			}
		}
		
		return min;
	}
	
	public Excursion getExcursion(Hotel hotel, LinkedList<Site> sites) {
		List<Site> res = new ArrayList<Site>();
		List<Path> paths = new ArrayList<Path>();

		LocalTime start_time = LocalTime.of(8, 0);
		Duration time = Duration.ZERO;
		Duration threshold = Duration.ofSeconds(1 * 3600);

		// start at hotel
		Station hotelStation = hotel.getStation();

		Site cur = sites.pop();
		// hotel to site path
		
		Path firstPath = findCheapestPath(hotelStation, cur.getStation());
		int dur = firstPath.getPathDuration(start_time);
		time = time.plus(Duration.ofSeconds(dur + cur.getDuration()));
		paths.add(firstPath);
		res.add(cur);
		
		Path prevBackPath = findCheapestPath(cur.getStation(), hotelStation);	
		prevBackPath.getPathDuration(start_time.plus(time));
		
		while(time.compareTo(threshold) < 0) {
			// sanity check
			if(sites == null || sites.size() == 0) {
				paths.add(prevBackPath);
				break;
			}

			// Find the minimum site to go to and back to hotel
			Site next = getMinSite(cur, hotelStation, sites);

			Path awayPath = findCheapestPath(cur.getStation(), next.getStation());
			Path backPath = findCheapestPath(next.getStation(), hotelStation);

			// Duration to go to site
			LocalTime awayTime = start_time.plus(time);
			int awayDuration = awayPath.getPathDuration(awayTime);
			// to spend time at site
			int siteDuration = next.getDuration();
			// to go back to hotel
			LocalTime backTime = awayTime.plus(Duration.ofSeconds(siteDuration + awayDuration));
			int backDuration = backPath.getPathDuration(backTime);

			// if a site was found
			// add to the excursion
			// otherwise finish up the excursion go back to the hotel
			if(time.plusSeconds(awayDuration + siteDuration + backDuration).compareTo(threshold) < 0) {
				paths.add(awayPath); // add the path back to hotel
				res.add(next); // add to the excursion
				sites.remove(next); // remove from list of sites to visit

				cur = next;
			} else {
				paths.add(prevBackPath);
				break;
			}

			time = time.plusSeconds(awayDuration + siteDuration);	
			prevBackPath = backPath;
		}

		return new Excursion(1, res, paths);
	}
	
	public ArrayList<Excursion> getExcursions(Hotel hotel, LinkedList<Site> sites) {
		ArrayList<Excursion> res = new ArrayList<Excursion>();
		while(sites.size() != 0) {
			res.add(getExcursion(hotel, sites));
		}
		return res;
	}
}
