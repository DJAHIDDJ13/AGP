package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import business.engine.PathFinding;
import business.transport.BusRoute;
import business.transport.BusStation;
import business.transport.Route;
import business.transport.Station;
import business.transport.Transport;

public class PathFindingTest {
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
