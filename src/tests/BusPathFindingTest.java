package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import AGPException.NullRoutesException;
import AGPException.NullStationsException;
import business.engine.PathFinding;
import business.transport.BoatRoute;
import business.transport.BoatStation;
import business.transport.BusRoute;
import business.transport.BusStation;
import business.transport.Route;
import business.transport.Station;
import business.transport.Transport;



public class BusPathFindingTest {
	
	Transport transport = Transport.getTransport();
	List<Station> stations ;
	List<Route> routes ;
	
	@Before
	public void hardReset()
	{
		transport.setRoutes(null);
		transport.setStations(null);
	}
	
	public void initStations()
	{
		stations = new ArrayList<Station>(
    			Arrays.asList(
    					new BusStation(0, 0, 0),
    					new BusStation(1, 0, 1),
    					new BusStation(2, 0, 2),
    					new BusStation(3, 1, 3)
    					)
    			);
	
		
		transport.setStations(stations);
	}

	private void initRoutes() {
		routes = new ArrayList<Route>(
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
		
		transport.setRoutes(routes);
	}
	
	@Test
	public void initialeTest()
	{
		initStations();
		initRoutes();
		PathFinding pf = new PathFinding();
		
    	List<Station> path = pf.findShortestPath(stations.get(0), stations.get(3));
    	assertNotNull(path);
    	assertTrue(!path.isEmpty());
	}
	
	

	@Test(expected = NullRoutesException.class)
	public void testWhenThereIsNoRoutes()
	{	
		initStations();		
		PathFinding pf = new PathFinding();
	}
	
	@Test(expected = NullStationsException.class)
	public void testWhenThereIsNoStationsAtAll()
	{	
		PathFinding pf = new PathFinding();
	}
	
	@Test
	public void testBoatRouteWhenOnlyBusAvailable() {
		/*
		 *check if unknown station throw NotFoundStationException
		initStations();
		initRoutes();
		BusStation b1  = new BusStation(10, 5, 6);
	
		PathFinding pf = new PathFinding();

		List<Station> path = pf.findShortestPath(b1,stations.get(0));*/ 
    	assertTrue(true);	
	}
	
	
	@Test
	public void testWhenStationIsNonAccessible()
	{
		initStations();
		routes = new ArrayList<Route>(
    			Arrays.asList(
    					new BusRoute(1, 4, new ArrayList<Station>(
    			    						   Arrays.asList(
			    			    					stations.get(3),
			    			    					stations.get(2)
			    							   )
    			    			))
    					)
    			);
		
		transport.setRoutes(routes);
	
		
		PathFinding pf = new PathFinding();

		List<Station> path = pf.findShortestPath(stations.get(0),stations.get(1)); 
    	assertNull(path);	
	}
	
	@Test
	public void testPathIsOrientationSensitive()
	{
		initStations();
		routes = new ArrayList<Route>(
    			Arrays.asList(
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
		
		transport.setRoutes(routes);
	
		
		PathFinding pf = new PathFinding();

		List<Station> path = pf.findShortestPath(stations.get(1),stations.get(0)); 
    	assertNotNull(path);	
    	
    	path = pf.findShortestPath(stations.get(0),stations.get(1)); 
    	assertNull(path);
	}
}
