package business.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import business.transport.Route;
import business.transport.Station;
import business.transport.Transport;

public class PathFinding {

	private Transport transport;

	Graph<Station> transport_graph; // path graph
	private HashMap<Station, List<Route>> buckets;
	
	// routes graph 
	public PathFinding() {
		this.transport = Transport.getTransport();
		buildGraph();
		buildBuckets(); // TODO: remove
	}
	
	private void buildGraph() {
	    Collection<Route> routes = transport.getRoutes();
	    Collection<Station> stations = transport.getStations();
	    transport_graph = new Graph<Station>(stations.size());

	    for(Route route: routes) {
	    	ListIterator<Station> stationIter = route.getStations().listIterator();
	        if(!stationIter.hasNext()) continue;
	        
	        Station src = stationIter.next();
	        while(stationIter.hasNext()) {
	            Station dst = stationIter.next();
	            Node<Station> dstNode = new Node<Station>(dst, src.distanceFrom(dst));
	            transport_graph.addAdjacencyEntry(src, dstNode);
	            src = dst;
	        }
	    }
	}
	
	public List<Station> findShortestPath(Station A, Station B) {
		transport_graph.dijkstra(A);
		
		List<Station> path = (List<Station>)(Object)transport_graph.getPath(A, B);
		
		return path; // this might be dangerous, TODO: find a better way
	}
	
	/*
	 * TODO: put this in transport
	 */
	private int calculateNumStationsInRoutes() {
		int n = 0;
		Collection<Route> routes = transport.getRoutes();
		for(Route r: routes) {
			n += r.getStations().size();
		}
		return n;
	}
	
	/*
	 * TODO: put this in transport
	 */
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
	
	// TODO: This needs to change; not good
	private Graph<PathEntry> buildRouteGraph() {
		int num_station_routes = calculateNumStationsInRoutes();
		Graph<PathEntry> g = new Graph<PathEntry>(num_station_routes+2);

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
	        	
    	    	g.addAdjacencyEntry(srcEntry, new Node<PathEntry>(dstEntry, 0));
    	    	src = dst;
	        }
	    }
	    
		for(Station station: stations) {
	    	List<Route> lst = buckets.get(station); // shouldn't be too big, probably less than 10
	    	
	    	// get all the possible pairs of stations
	    	for (int i = 0; i < lst.size(); i++) {
	    	    for (int j = i + 1; j < lst.size(); j++) {
	    	    	Route srcRoute = lst.get(i);
	    	    	Route dstRoute = lst.get(j);
	    	    	
	    	    	PathEntry srcEntry = PathEntry.getEntry(station, srcRoute);
	    	    	PathEntry dstEntry = PathEntry.getEntry(station, dstRoute);

	    	    	g.addAdjacencyEntry(srcEntry, new Node<PathEntry>(dstEntry, dstRoute.getTicketPrice()));
	    	    }
	    	}
	    }
	    
		return g;
	}
	
	public Path findCheapestPath(Station A, Station B) { // (List<Station> path) {
		Graph<PathEntry> g = buildRouteGraph();
		
		// TODO: this is bad; find a better way
		// Adding the S and E node to the graph
		List<Route> strtStation = buckets.get(A); // get all the lines that pass by the start Station
		List<Route> endStation = buckets.get(B); // get all the lines that pass by the end Station

		// Adding the "S" node
		for	(Route r: strtStation) {
			String key = String.valueOf(A.getId())+";"+String.valueOf(r.getId());
			PathEntry entry = PathEntry.getEntry(A, r);
			
			g.addAdjacencyEntry("S", new Node<PathEntry>(entry, r.getTicketPrice()));
		}
		
		// Adding the "E" node
		for (Route r: endStation) {
			//String key = String.valueOf(B.getId())+";"+String.valueOf(r.getId());
			PathEntry entry = PathEntry.getEntry(B, r);
			g.addAdjacencyEntry(entry, new Node("E", 0));
		}
		
		g.dijkstra("S");
		
		// removing the S node
		g.removeAdjacencyList("S");
		
		// removing the E node
		// Undo nodes to last station
		HashMap<String, List<Node>> adj = g.getAdj();
		for (Route r: endStation) {
			String key = String.valueOf(B.getId())+";"+String.valueOf(r.getId());
			List<Node> endLst = adj.get(key);
			endLst.remove(endLst.size() - 1); 
			// remove last item added (which is the "E" node)
		}
		
		// TODO: Use this on the resulting path
		// TODO: change AbstractMap.SimpleEntry to something better
		List<PathEntry> lst = (List<PathEntry>) (Object) g.getPath("S", "E");

		if(lst == null) {
			return null;
		}
		
		lst.remove(0); lst.remove(lst.size() - 1); // remove the S and E nodes

		Path path = new Path(lst);
		
		return path;
	}
}