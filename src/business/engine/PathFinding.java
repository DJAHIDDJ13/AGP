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

	Graph transport_graph; // path graph
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
	    transport_graph = new Graph(stations.size());

	    for(Route route: routes) {
	    	ListIterator<Station> stationIter = route.getStations().listIterator();
	        if(!stationIter.hasNext()) continue;
	        
	        Station src = stationIter.next();
	        while(stationIter.hasNext()) {
	            Station dst = stationIter.next();
	            Node dstNode = new Node(String.valueOf(dst.getId()), src.distanceFrom(dst));
	            transport_graph.addAdjacencyEntry(String.valueOf(src.getId()), dst, dstNode);
	            src = dst;
	        }
	    }
	}
	
	public List<Station> findShortestPath(Station A, Station B) {
		transport_graph.dijkstra(String.valueOf(A.getId()));
		
		List<Object> path = transport_graph.getPath(String.valueOf(A.getId()), String.valueOf(B.getId()));
		
		return (List<Station>) (Object) path; // this might be dangerous, TODO: find a better way
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
	private Graph buildRouteGraph() {
		int num_station_routes = calculateNumStationsInRoutes();
		Graph g = new Graph(num_station_routes+2);

		Collection<Route> routes = transport.getRoutes();
	    Collection<Station> stations = transport.getStations();
	    
	    // connect all the consecutive route stations with a 0 weight node
	    for	(Route route: routes) {
	    	ListIterator<Station> stations1 = route.getStations().listIterator();
	        if(!stations1.hasNext()) continue;

	        Station src = stations1.next();
	        while(stations1.hasNext()) {
	            Station dst = stations1.next();
    	    	String srcKey = String.valueOf(src.getId())+";"+String.valueOf(route.getId());
    	    	String dstKey = String.valueOf(dst.getId())+";"+String.valueOf(route.getId());
    	    	
    	    	g.addAdjacencyEntry(srcKey, new Tuple<Station, Route>(dst, route), 
    	    			 					new Node(dstKey, 0));
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
	    	    	String srcKey = String.valueOf(station.getId())+";"+String.valueOf(srcRoute.getId());
	    	    	String dstKey = String.valueOf(station.getId())+";"+String.valueOf(dstRoute.getId());
	    	    	
	    	    	g.addAdjacencyEntry(srcKey, new Tuple<Station, Route>(station, dstRoute),
	    	    						        new Node(dstKey, dstRoute.getTicketPrice()));
	    	    }
	    	}
	    }
	    
		return g;
	}
	
	public Path findCheapestPath(Station A, Station B) { // (List<Station> path) {
		Graph g = buildRouteGraph();
		
		// TODO: this is bad; find a better way
		// Adding the S and E node to the graph
		List<Route> strtStation = buckets.get(A); // get all the lines that pass by the start Station
		List<Route> endStation = buckets.get(B); // get all the lines that pass by the end Station

		// Adding the "S" node
// 		List<Node> strtLst = new ArrayList<Node>();
		for	(Route r: strtStation) {
			String key = String.valueOf(A.getId())+";"+String.valueOf(r.getId());
			g.addAdjacencyEntry("S", new Tuple<Station, Route>(A, r), new Node(key, r.getTicketPrice()));
		}
		//g.addAdjacencyEntries("S", new Tuple<Station, Route>(B, r), strtLst);
		
		// Adding the "E" node
		for (Route r: endStation) {
			String key = String.valueOf(B.getId())+";"+String.valueOf(r.getId());
			g.addAdjacencyEntry(key, null, new Node("E", 0));
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
		List<Tuple<Station, Route>> lst = (List<Tuple<Station, Route>>) (Object) g.getPath("S", "E");

		if(lst == null) {
			return null;
		}
		
		lst.remove(0); lst.remove(lst.size() - 1); // remove the S and E nodes

		Path path = new Path(lst);
		
		return path;
	}
}