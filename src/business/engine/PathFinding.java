package business.engine;

import java.util.ArrayList;
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

	Graph transport_graph;

	private List<Route> routes;

	private List<Station> stations;
	
	public PathFinding()  {
		this.transport = Transport.getTransport();		

		initStations();

		initRoutes();

		this.transport_graph = buildGraph();
}

	private void initRoutes()  {
		
		this.routes = transport.getRoutes();
		
	    if(routes == null || routes.isEmpty()) {
	    	throw new NullRoutesException();
	    }

	}
	
	private void initStations()  {
		
		this.stations = transport.getStations();
		
	    if(stations == null || stations.isEmpty()) {
	    	throw new NullStationsException();
	    }

	}
	
	private Graph buildGraph() {
	    HashMap<Integer, List<Node>> adj = new HashMap<Integer, List<Node>>();
	    
	    
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
			Node n = prev[curId];
			if(n == null) {
				return null;
			}
			curId = n.node;
		}
		path.add(transport.getStations().get(0));
		Collections.reverse(path); // put them in the right order
		
		return path;
	}
}
