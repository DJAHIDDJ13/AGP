package business.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import business.transport.BusRoute;
import business.transport.BusStation;
import business.transport.Route;
import business.transport.Station;
import business.transport.Transport;

public class PathFinding {
	private Transport transport;

	Graph transport_graph;
	
	public PathFinding() {
		this.transport = Transport.getTransport();
		this.transport_graph = buildGraph();
	}

	private Graph buildGraph() {
	    HashMap<Integer, List<Node>> adj = new HashMap<Integer, List<Node>>();
	    
	    List<Route> routes = transport.getRoutes(); // TODO: refactor this
	    for(Route route: routes) {
	    	ListIterator<Station> stations = route.getStations().listIterator();
	        if(!stations.hasNext()) continue;
	        
	        Station src = stations.next();
	        while(stations.hasNext()) {
	            Station dst = stations.next();
	            Node dstNode = new Node(dst.getId(), src.distanceFrom(dst));
	            
	    	    List<Node> lst = adj.get(src.getId());
	    	    if(lst == null) {
	    	    	lst = new ArrayList<Node>();
	    	    	adj.put(src.getId(), lst);
	    	    }
	    	    lst.add(dstNode);
	    	    
	    	    src = dst;
	        }
	    }
	    
	    Graph tg = new Graph(transport.getStations().size(), adj);

	    return tg;
	}

	public List<Station> findShortestPath(Station A, Station B) {
		transport_graph.dijkstra(A.getId());
		Node prev[] = transport_graph.getPrev();
		
		List<Station> path = new ArrayList<Station>();
		
		int curId = B.getId();
		while(curId != A.getId()) {
			path.add(transport.getStations().get(curId)); // TODO: optimize this 
			curId = prev[curId].node;
		}
		path.add(transport.getStations().get(0));
		Collections.reverse(path); // put them in the right order
		
		return path;
	}
	
	// For testing 
	// TODO: make this into a JUnit test
    public static void main(String arg[]) { 
    	Transport t = Transport.getTransport();
    	List<Station> stations = new ArrayList<Station>(
    			Arrays.asList(
    					new BusStation(0, 0, 0),
    					new BusStation(1, 0, 1),
    					new BusStation(2, 0, 2),
    					new BusStation(3, 1, 3)
    					)
    			);
    	
    	List<Route> routes = new ArrayList<Route>(
    			Arrays.asList(
    					new BusRoute(1, 4, new ArrayList<>(stations)),
    					new BusRoute(1, 4, new ArrayList<Station>(
    			    						   Arrays.asList(
			    			    					stations.get(3),
			    			    					stations.get(2),
			    			    					stations.get(1),
			    			    					stations.get(0)
    			    						   )
    			    			))
    					)
    			);
    	t.setStations(stations);
    	t.setRoutes(routes);
    	
    	PathFinding pf = new PathFinding();
    	List<Station> path = pf.findShortestPath(stations.get(0), stations.get(3));
    	for(Station s: path) {
    		System.out.println(s.getId());
    	}
    }
}
