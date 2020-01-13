package business.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import AGPException.NullRoutesException;
import AGPException.NullStationsException;
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
		this.transport_graph = buildGraph();
		buildBuckets(); // TODO: remove
	}
	
	private Graph buildGraph() {
	    HashMap<String, List<Node>> adj = new HashMap<String, List<Node>>();
	    Collection<Route> routes = transport.getRoutes();
	    Collection<Station> stations = transport.getStations();

		if(stations == null ) {
			throw new NullStationsException();
		} else if(routes == null) {
			throw new NullRoutesException();
		}
		
	    for(Route route: routes) {
	    	ListIterator<Station> stationIter = route.getStations().listIterator();
	        if(!stationIter.hasNext()) continue;
	        
	        Station src = stationIter.next();
	        while(stationIter.hasNext()) {
	            Station dst = stationIter.next();
	            Node dstNode = new Node(String.valueOf(dst.getId()), src.distanceFrom(dst));
	            
	    	    List<Node> lst = adj.get(String.valueOf(src.getId()));
	    	    if(lst == null) {
	    	    	lst = new ArrayList<Node>();
	    	    	adj.put(String.valueOf(src.getId()), lst);
	    	    }
	    	    lst.add(dstNode);
	    	    
	    	    src = dst;
	        }
	    }
	    
	    Graph tg = new Graph(stations.size(), adj);

	    return tg;
	}
	
	public List<Station> findShortestPath(Station A, Station B) {
		transport_graph.dijkstra(String.valueOf(A.getId()));
		
		HashMap<String, Node> prev = transport_graph.getPrev();
		
		List<Station> path = new ArrayList<Station>();
		
		// TODO: use the getPath method of Graph
		int curId = B.getId();
		while(curId != A.getId()) {
			path.add(transport.getStationById(curId)); // TODO: optimize this 

			Node n = prev.get(String.valueOf(curId));
			if(n == null) {
				return null;
			}
			
			curId = Integer.parseInt(n.node);
		}
		
		path.add(transport.getStationById(0)); // add the source station
		Collections.reverse(path); // put them in the right order
		
		return path;
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
		Collection<Route> routes = transport.getRoutes();
	    Collection<Station> stations = transport.getStations();
		//List<Station> stations = transport.getStations();
		int num_station_routes = calculateNumStationsInRoutes();
	    HashMap<String, List<Node>> adj = new HashMap<String, List<Node>>();
	    
	    // connect all the consecutive route stations with a 0 weight node
	    for	(Route route: routes) {
	    	ListIterator<Station> stations1 = route.getStations().listIterator();
	        if(!stations1.hasNext()) continue;

	        Station src = stations1.next();
	        while(stations1.hasNext()) {
	            Station dst = stations1.next();
    	    	String srcKey = String.valueOf(src.getId())+";"+String.valueOf(route.getId());
    	    	String dstKey = String.valueOf(dst.getId())+";"+String.valueOf(route.getId());
    	    	
    	    	/** Should put this in a seperate function*/
    	    	List<Node> nodeLst = adj.get(srcKey);//.add(lst.get(j));
    	    	if(nodeLst == null) {
    	    		nodeLst = new ArrayList<Node>();
    	    		adj.put(srcKey, nodeLst);
    	    	}
    	    	
    	    	// add a node between all the stations shared between multiple lines
    	    	nodeLst.add(new Node(dstKey, 0)); 
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
	    	    	
	    	    	/** TODO: Should put this in a seperate function*/
	    	    	List<Node> nodeLst = adj.get(srcKey);
	    	    	if(nodeLst == null) {
	    	    		nodeLst = new ArrayList<Node>();
	    	    		adj.put(srcKey, nodeLst);
	    	    	}
	    	    	
	    	    	// add a node between all the stations shared between multiple lines
	    	    	nodeLst.add(new Node(dstKey, 1));  
	    	    }
	    	}
	    }
	    
		Graph g = new Graph(num_station_routes+1, adj);
		return g;
	}
	
	public List<Route> findCheapestPath(Station A, Station B) { // (List<Station> path) {
		Graph g = buildRouteGraph();
		
		HashMap<String, List<Node>> adj = g.getAdj(); // TODO: make this a method in Graph class (to add an entry to adj)
		
		// TODO: this is bad; find a better way
		List<Route> strtStation = buckets.get(A); // get all the lines that pass by the start Station
		List<Route> endStation = buckets.get(B); // get all the lines that pass by the end Station
		
		List<Node> strtLst = new ArrayList<Node>();
		for	(Route r: strtStation) {
			String key = String.valueOf(A.getId())+";"+String.valueOf(r.getId());
			strtLst.add(new Node(key, 1));
		}

		for (Route r: endStation) {
			String key = String.valueOf(B.getId())+";"+String.valueOf(r.getId());
			// Especially this
			try {
				adj.get(key).add(new Node("E", 1));
			} catch(NullPointerException e) {
				adj.put(key, new ArrayList<Node>()); 
				adj.get(key).add(new Node("E", 1));
			}
		}
		
		adj.put("S", strtLst);
		g.dijkstra("S");
		adj.remove("S");
		
		// Undo nodes to last station
		// this is worse
		for (Route r: endStation) {
			String key = String.valueOf(B.getId())+";"+String.valueOf(r.getId());
			List<Node> endLst = adj.get(key);
			endLst.remove(endLst.size() - 1); // remove last item added
		}
		
		// TODO: Find a better way to do this
		ListIterator<String> prev = g.getPath("S", "E").listIterator();
		
		// transform list of string to list of Route
		List<Route> res = new ArrayList<Route>();

		prev.next();
		String cur = prev.next();
		
		int split = cur.indexOf(";");
		
		int prevRouteId = -1;
		int curRouteId = Integer.parseInt(cur.substring(split + 1));
		while(prev.hasNext()) {
			split = cur.indexOf(";");
			if(split == -1) {
				break;
			}
			
			if(curRouteId != prevRouteId) {
				res.add(transport.getRouteById(curRouteId));
			}
			cur = prev.next();
			prevRouteId = curRouteId;
		}
		return res;
	}
}
